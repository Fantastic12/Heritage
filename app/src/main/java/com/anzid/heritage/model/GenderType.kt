package com.anzid.heritage.model

enum class GenderType {
    MALE, FEMALE;

    fun toInt() = this.ordinal

    companion object {
        fun toGenderType(int: Int): GenderType = values()[int]
    }
}