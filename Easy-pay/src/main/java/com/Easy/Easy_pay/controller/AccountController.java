package com.Easy.Easy_pay.controller;

import com.Easy.Easy_pay.dto.AccountDto;
import com.Easy.Easy_pay.model.Account;
import com.Easy.Easy_pay.service.AccountService;
import com.Easy.Easy_pay.service.AccountServiceImp;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
// these is an base Api protocol where all the Api will be followed
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping
    // Add account REST API
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    // Get account REST API
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }
    @PutMapping("/{id}/deposite")
    // update the account REST API
    public ResponseEntity<AccountDto> deposite(@PathVariable Long id, @RequestBody Map<String , Double> request ){
        AccountDto accountDto = accountService.deposite(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}/withDraw")
    public ResponseEntity<AccountDto> withDraw (@PathVariable Long id, @RequestBody Map<String , Double> request){
        AccountDto accountDto = accountService.withDraw(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount (){
        List<AccountDto> accountDto = accountService.getAllAccount();
        return ResponseEntity.ok(accountDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount (@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account was deleted sucessfully");
    }
}
