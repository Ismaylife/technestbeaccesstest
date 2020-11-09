package com.example.technestbeaccesstest.domain.services

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.repositories.AccountsRepository

class DoATransfer (
    private val accountsRepository : AccountsRepository){
        fun invoke (origin : String, receiver : String, quantity: Double){
            val receiver = accountsRepository.getReceiver(receiver)
            val origin = accountsRepository.getOrigin(origin)
            if (checkBalance(origin, quantity)){
                origin[0].balance -= quantity
                receiver[0].balance += quantity
            }

        }

    private fun checkBalance(origin: List<Account>, quantity: Double) : Boolean{
        return if (origin[0].balance - quantity < 0){
            origin[0].treasury
        }
        else{
            true
        }
    }
    }

