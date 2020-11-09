package com.example.technestbeaccesstest.presentation.accounts
import com.example.technestbeaccesstest.domain.services.AddNewAccount
import com.example.technestbeaccesstest.domain.services.CheckAccount
import com.example.technestbeaccesstest.domain.services.DoATransfer
import com.example.technestbeaccesstest.presentation.accounts.dtos.NewAccountDto
import com.example.technestbeaccesstest.presentation.accounts.mappers.toAccount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class AccountsController{

    @Autowired
    lateinit var addNewAccount: AddNewAccount
    @PostMapping("/accounts")
    fun addNewAccount(@RequestBody newAccountDto : NewAccountDto) {
        addNewAccount.invoke(newAccountDto.toAccount())
    }

    @Autowired
    lateinit var doATransfer: DoATransfer
    @GetMapping("/accounts/{transfer}")
    fun doATransfer(@RequestParam origin : String, @RequestParam receiver: String, @RequestParam quantity: Double){
        doATransfer.invoke(origin, receiver, quantity)
    }

    @Autowired
    lateinit var checkAccount: CheckAccount
    @PostMapping("/account")
    fun checkAccount(@RequestParam name: String){
        return checkAccount.invoke(name)
    }
}