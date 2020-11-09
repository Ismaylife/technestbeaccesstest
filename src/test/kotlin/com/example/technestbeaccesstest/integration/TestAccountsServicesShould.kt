package com.example.technestbeaccesstest.integration

import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.repositories.AccountsRepository
import com.example.technestbeaccesstest.domain.services.AddNewAccount
import com.example.technestbeaccesstest.domain.services.CheckAccount
import com.example.technestbeaccesstest.domain.services.DoATransfer
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
@ContextConfiguration
@AutoConfigureMockMvc
class TestAccountsServicesShould {
    @Autowired
    lateinit var checkAccount: CheckAccount

    @Test
    fun retrieve_an_account_with_given_name(){
        val result = checkAccount.invoke("Pepe")
        assertEquals(result[0].name, "Pepe")
    }

    @Autowired
    lateinit var addNewAccount: AddNewAccount
    @Autowired
    lateinit var accounts : AccountsRepository

    @Test
    fun add_new_user(){
        val firstSize = accounts.getList().size
        addNewAccount.invoke(Account(name = "Sergio", currency = "EUR", balance = 200.00, treasury = false))
        val newAccountsList = accounts.getList()
        assertThat(accounts.getList().size == firstSize + 1 )
        assertThat(newAccountsList[newAccountsList.size - 1].name == "Sergio")
    }

    @Autowired
    lateinit var doATransfer: DoATransfer

    @Test
    fun do_a_transfer_between_two_accounts_with_positive_balance(){
        val originBeforeTranfer = accounts.getOrigin("Pepe")
        val receiverBeforeTransfer = accounts.getReceiver("Juan")

        doATransfer.invoke("Pepe", "Juan", 100.00)

        val originAfterTransfer = accounts.getOrigin("Pepe")
        val receiverAfterTransfer = accounts.getReceiver("Juan")

        assertThat(originBeforeTranfer[0].balance == originAfterTransfer[0].balance - 100.00)
        assertThat(receiverBeforeTransfer[0].balance == receiverAfterTransfer[0].balance + 100.00)
    }

}