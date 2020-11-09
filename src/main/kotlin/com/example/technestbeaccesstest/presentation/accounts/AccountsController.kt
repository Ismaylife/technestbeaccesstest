package com.example.technestbeaccesstest.presentation.accounts

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.services.AddNewAccount
import org.springframework.beans.factory.annotation.Autowired

class AccountsController {

    @Autowired
    lateinit var addNewAccount: AddNewAccount
    fun addNewAccount(newAccount: Account){
        addNewAccount.invoke(newAccount)
    }
}