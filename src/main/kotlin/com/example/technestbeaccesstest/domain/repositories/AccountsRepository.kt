package com.example.technestbeaccesstest.domain.repositories

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.services.AddNewAccount

interface AccountsRepository {
    fun addNewAccount(account: Account)
    fun getReciver(receiver: String): List<Account>
    fun getOrigin(origin: String): List<Account>

}