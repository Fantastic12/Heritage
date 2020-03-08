package com.anzid.heritage.repository

import com.anzid.core.db.datasource.LocalDbDataSource
import javax.inject.Inject

class HeritageRepositoryImp @Inject constructor(private val localDbDataSource: LocalDbDataSource) : HeritageRepository {
}