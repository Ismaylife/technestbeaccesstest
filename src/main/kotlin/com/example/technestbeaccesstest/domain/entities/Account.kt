package com.example.technestbeaccesstest.domain.entities

data class Account (
        val name : String,
        var currency: String,
        var balance: Double,
        val treasury: Boolean
)
