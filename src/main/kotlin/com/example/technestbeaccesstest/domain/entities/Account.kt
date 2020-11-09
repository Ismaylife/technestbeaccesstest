package com.example.technestbeaccesstest.domain.entities

data class Account (
        val name : String,
        val currency: String,
        val balance: Double,
        val treasury: Boolean
)
