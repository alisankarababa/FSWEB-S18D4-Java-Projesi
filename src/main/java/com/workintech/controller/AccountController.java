package com.workintech.controller;

import com.workintech.dto.AccountResponse;
import com.workintech.entity.Account;
import com.workintech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable long id) {
        return accountService.findById(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@PathVariable long customerId, @RequestBody Account account) {

        return accountService.save(customerId, account);
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@PathVariable long customerId, @RequestBody Account account) {
        return accountService.update(customerId, account);
    }

    @DeleteMapping("/{id}")
    public AccountResponse delete(@PathVariable long id) {
        return accountService.delete(id);
    }
}
