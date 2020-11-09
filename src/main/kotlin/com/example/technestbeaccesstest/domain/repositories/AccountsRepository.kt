package com.example.technestbeaccesstest.domain.repositories

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.services.AddNewAccount

interface AccountsRepository {
    fun addNewAccount(account: Account)
    fun getReceiver(receiver: String): List<Account>
    fun getOrigin(origin: String): List<Account>
    fun getList(): List<Account>
    fun checkAccount(name: String): List<Account>
}