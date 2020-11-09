package com.example.technestbeaccesstest.presentation.accounts.mappers

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.presentation.accounts.dtos.AccountResponseDto
import com.example.technestbeaccesstest.presentation.accounts.dtos.NewAccountDto

fun List<Account>.toAccountsDto() = map {it.toAccountsDto() }
fun Account.toAccountsDto()=
        AccountResponseDto(
                name = name,
                currency = currency,
                balance = balance,
                treasury = treasury
        )
fun NewAccountDto.toAccount() =
        Account(
                name = name,
                currency = currency,
                balance = balance,
                treasury = treasury
        )