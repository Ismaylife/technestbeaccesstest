package com.example.technestbeaccesstest.domain.services

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.repositories.AccountsRepository

class AddNewAccount (
        private val accountsRepository : AccountsRepository){
    fun invoke (account : Account){
        accountsRepository.addNewAccount(account)
    }
}