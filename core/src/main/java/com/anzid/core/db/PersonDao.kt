package com.anzid.core.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonDao {

    @Query(value = "SELECT * FROM ${PersonEntity.TABLE_NAME}")
    fun getAllPersons(): LiveData<List<PersonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(personEntity: PersonEntity)

    @Query(value = "DELETE FROM ${PersonEntity.TABLE_NAME} WHERE idPerson = :id")
    fun deletePersonById(id: Long)

    @Query("SELECT COUNT(idPerson) FROM ${PersonEntity.TABLE_NAME}")
    fun getAllPersonsCount(): Int

    @Query(value = "SELECT * FROM ${PersonEntity.TABLE_NAME} WHERE name = :name")
    fun findPersonByName(name: String): Boolean

    @Query(value = "SELECT * FROM ${PersonEntity.TABLE_NAME} WHERE idPerson = :Id")
    fun findPersonById(Id: String): Boolean

    @Query(value = "DELETE FROM ${PersonEntity.TABLE_NAME}")
    fun cleanTable()
}