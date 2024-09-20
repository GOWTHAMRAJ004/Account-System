package com.Easy.Easy_pay.service;

import com.Easy.Easy_pay.dto.AccountDto;
import com.Easy.Easy_pay.mapper.AccountMapper;
import com.Easy.Easy_pay.model.Account;
import com.Easy.Easy_pay.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements  AccountService{
    @Autowired
    AccountRepository accountRepository;
    @Override
    public AccountDto createAccount(AccountDto accountdto) {
       Account account = AccountMapper.mapToAccount(accountdto);
       Account savedAccount = accountRepository.save(account);
       return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account getAccounts = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
       return AccountMapper.mapToAccountDto(getAccounts);
    }

    @Override
    public AccountDto deposite(Long id, double amount) {
        // to check the given account is existing or not
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist "));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withDraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist "));
        if(account.getBalance() < amount){
            throw new RuntimeException("insufficient balance");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAcount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAcount);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
     }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist "));
        accountRepository.deleteById(id);
    }
}
