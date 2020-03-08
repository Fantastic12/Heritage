package com.anzid.core.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.anzid.core.db.PersonEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) var idPerson: Long = 0L,
    var name: String,
    var surName: String,
    var age: Int,
    var gender: Int,
    var isDied: Boolean = false,
    var smallDescription: String,
    val description: String,
    var avatar_link: String? = null
) {

    companion object {
        const val TABLE_NAME = "person_table"
    }
}