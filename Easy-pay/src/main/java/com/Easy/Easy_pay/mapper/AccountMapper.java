package com.Easy.Easy_pay.mapper;

import com.Easy.Easy_pay.dto.AccountDto;
import com.Easy.Easy_pay.model.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(accountDto.getId(),accountDto.getAccountHolderName(), accountDto.getBalance());
        return account;
    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountdto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountdto;
    }
}
