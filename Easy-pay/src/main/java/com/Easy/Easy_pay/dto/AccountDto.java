package com.Easy.Easy_pay.dto;

import lombok.Data;

@Data
public class AccountDto {
    public AccountDto(Long id, String accountHolderName, Double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    private Long id;
    private String accountHolderName;
    private Double balance;
}
