package com.anzid.core.db.datasource

import com.anzid.core.db.HeritageDb
import com.anzid.core.db.PersonEntity
import javax.inject.Inject

class LocalDbDataSourceImpl @Inject constructor(heritageDb: HeritageDb) : LocalDbDataSource {

    private var personDao = heritageDb.personDao()

    override fun getAllPersons() = personDao.getAllPersons()
    override fun insertPerson(personEntity: PersonEntity) = personDao.insertPerson(personEntity)
    override fun deletePersonById(id: Long) = personDao.deletePersonById(id)
    override fun getAllPersonsCount() = personDao.getAllPersonsCount()
    override fun findPersonByName(name: String) = personDao.findPersonByName(name)
    override fun findPersonById(id: String) = personDao.findPersonById(id)

    override fun cleanData() = personDao.cleanTable()
}