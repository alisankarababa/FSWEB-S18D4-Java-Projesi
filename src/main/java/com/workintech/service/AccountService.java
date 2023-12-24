package com.workintech.service;

import com.workintech.dto.AccountResponse;
import com.workintech.entity.Account;
import java.util.List;

public interface AccountService {
    List<AccountResponse> findAll();
    AccountResponse findById(long id);
    AccountResponse save(long customerId, Account account);
    AccountResponse delete(long id);

    AccountResponse update(long customerId, Account account);

}
