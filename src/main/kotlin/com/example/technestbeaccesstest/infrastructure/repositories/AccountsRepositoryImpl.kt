package com.example.technestbeaccesstest.infrastructure.repositories

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.repositories.AccountsRepository
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.stereotype.Repository

@Repository
class AccountsRepositoryImpl () : AccountsRepository{
    val accounts = mutableListOf<Account>(
            Account("Pepe", "EUR", 300.00, true),
            Account("Juan", "EUR", 250.50, true),
            Account("Antonio", "EUR", 10.30, false),
            Account("Jose", "EUR", 1223.30, true)
    )

    override fun addNewAccount(newAccount : Account){
        accounts.add(newAccount)
    }

    override fun getReceiver(receiver: String): List<Account> {
        val receiver = accounts.filter { it.name == receiver }
        return receiver
    }

    override fun getOrigin(origin: String): List<Account> {
        val origin = accounts.filter { it.name == origin }
        return origin
    }

    override fun getList(): List<Account>{
        return accounts
    }

    override fun checkAccount( name : String): List<Account>{
        return accounts.filter { it.name == name }
    }


}



