package com.example.technestbeaccesstest.domain.services

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.repositories.AccountsRepository

class CheckAccount (
    private val accountsRepository : AccountsRepository){
        fun invoke (name : String){
            accountsRepository.checkAccount(name)
        }
}