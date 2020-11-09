package com.example.technestbeaccesstest.presentation.accounts.dtos

data class AccountResponseDto(
        val name: String,
        val currency: String,
        val balance: Double,
        val treasury: Boolean
)

data class NewAccountDto(
        val name: String,
        val currency: String,
        val balance: Double,
        val treasury: Boolean
)

data class TransferResponseDto(
        val origin: String,
        val receiver: String,
        val balance: Double
)