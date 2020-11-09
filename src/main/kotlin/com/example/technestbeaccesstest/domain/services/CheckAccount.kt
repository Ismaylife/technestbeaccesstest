package com.example.technestbeaccesstest.domain.services

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.repositories.AccountsRepository
import org.springframework.stereotype.Service

@Service
class CheckAccount (
    private val accountsRepository : AccountsRepository){
        fun invoke (name : String) : List<Account>{
            return accountsRepository.checkAccount(name)
        }
}