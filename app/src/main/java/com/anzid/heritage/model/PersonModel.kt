package com.anzid.heritage.model

data class PersonModel(
    var idPerson: Long = 0L,
    var name: String,
    var surName: String,
    var age: Int,
    var gender: GenderType,
    var isDied: Boolean = false,
    var smallDescription: String,
    val description: String,
    var avatar_link: String? = null
)