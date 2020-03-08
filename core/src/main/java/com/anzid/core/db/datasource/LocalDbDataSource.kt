package com.anzid.core.db.datasource

import androidx.lifecycle.LiveData
import com.anzid.core.db.PersonEntity

interface LocalDbDataSource {

    fun getAllPersons(): LiveData<List<PersonEntity>>
    fun insertPerson(personEntity: PersonEntity)
    fun deletePersonById(id: Long)
    fun getAllPersonsCount(): Int
    fun findPersonByName(name: String): Boolean
    fun findPersonById(id: String): Boolean
    fun cleanData()
}