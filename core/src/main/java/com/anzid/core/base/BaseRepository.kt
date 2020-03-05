package com.anzid.core.base

import com.anzid.core.exceptions.ErrorReceivingRestResponseBody
import com.anzid.core.rest.RestRequestType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseRepository {

    protected fun <DT> sendRestRequestWithProcessDataInLocalDb(
        restRequestType: RestRequestType,
        restRequest: () -> Deferred<Response<DT>>,
        processDataInLocalDb: () -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {
        val response = restRequest().await()
        try {
            if (response.isSuccessful) {
                when (restRequestType) {
                    RestRequestType.POST -> processDataInLocalDb()
                    RestRequestType.GET -> response.body()?.let { processDataInLocalDb() }
                        ?: throw ErrorReceivingRestResponseBody("Error receiving response body" + response.message())
                    RestRequestType.UPDATE -> processDataInLocalDb()
                    RestRequestType.DELETE -> processDataInLocalDb()
                }
            } else throw ErrorReceivingRestResponseBody("Error response" + response.code())
        } catch (e: Exception) {
            when (e) {
                is HttpException -> e.printStackTrace()
                is ErrorReceivingRestResponseBody -> e.printStackTrace()
                else -> e.printStackTrace()
            }
        }
    }
}