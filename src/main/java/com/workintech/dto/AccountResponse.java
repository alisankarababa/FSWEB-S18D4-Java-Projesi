package com.workintech.dto;

import com.workintech.entity.Account;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AccountResponse {

    private long id;
    private String accountName;
    private double moneyAmount;

    private AccountResponse() {

    }

    private AccountResponse(long id, String accountName, double moneyAmount) {
        this.id = id;
        this.accountName = accountName;
        this.moneyAmount = moneyAmount;
    }

    public static AccountResponse convert(Account account) {
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());
    }

    public static List<AccountResponse> convert(List<Account> accounts) {

        List<AccountResponse> list = new ArrayList<>();
        accounts.forEach(account -> list.add(AccountResponse.convert(account)));
        return list;
    }


}
