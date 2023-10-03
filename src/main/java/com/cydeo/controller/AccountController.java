package com.cydeo.controller;

import com.cydeo.enums.AccountType;
import com.cydeo.module.Account;
import com.cydeo.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class AccountController {

    /*
        write a method to return index.html including account list information
        endpoint:index
     */
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/index")
    public String getIndexPage(Model model){

        model.addAttribute("accountList",accountService.listAllAccount());
        return "account/index";
    }


    @GetMapping("/create-form")
    public String createForm(Model model) {
        //need an empty account object to hold data
        model.addAttribute("account", Account.builder().build());
        //need to provide accountType enum values to the view page
        model.addAttribute("accountTypes", AccountType.values());

        return "account/create-account";
    }

    //create a method to capture information from ui
    //print them on the console.
    //trigger createNewAccount method, create the account based on the user input.
    //once user created return back to the index page.
    @PostMapping("/create")
    public String createAccount(@ModelAttribute("account") Account account){
        System.out.println(account);
        accountService.createNewAccount(account.getBalance(),new Date(),account.getAccountType(),account.getUserId());
        return "redirect:/index";
    }



}