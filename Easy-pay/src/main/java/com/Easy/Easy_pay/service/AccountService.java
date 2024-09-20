package com.Easy.Easy_pay.service;

import com.Easy.Easy_pay.dto.AccountDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component

public interface AccountService {
    AccountDto createAccount(AccountDto accountdto);
    AccountDto getAccountById(Long id);

    AccountDto deposite (Long id, double amount);
    AccountDto withDraw (Long id, double amount);
   List<AccountDto> getAllAccount ();
   void deleteAccount (Long id);
}
