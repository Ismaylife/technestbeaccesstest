package com.example.technestbeaccesstest.integration
import com.example.technestbeaccesstest.domain.entities.Account
import com.example.technestbeaccesstest.domain.repositories.AccountsRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.util.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@ExtendWith(SpringExtension::class)
@ContextConfiguration
@AutoConfigureMockMvc
class TestAccountsControllerShould {
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var accountsRepository: AccountsRepository

    private val  mockedAccounts = listOf(
            Account("Pepe", "EUR", 300.00, true),
            Account("Juan", "EUR", 250.50, true),
            Account("Antonio", "EUR", 10.30, false),
            Account("Jose", "EUR", 1223.30, true)
    )

    @BeforeEach
    fun setup(){
        `when`(accountsRepository.getOrigin("Pepe")).thenReturn(mockedAccounts)
    }

    @Test
    fun retrieve_the_origin_account() {
        val origin = accountsRepository.getOrigin("Pepe")
        for ((index, origin) in origin.withIndex()) {
            assertThat(origin.name).isEqualTo(mockedAccounts[index].name);
        }
    }
}