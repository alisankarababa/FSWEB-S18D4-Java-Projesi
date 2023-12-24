package com.workintech.service;

import com.workintech.dto.AccountResponse;
import com.workintech.entity.Account;
import com.workintech.entity.Customer;
import com.workintech.repository.AccountRepository;
import com.workintech.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {

        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<AccountResponse> findAll() {
        return AccountResponse.convert(accountRepository.findAll());
    }

    @Override
    public AccountResponse findById(long id) {

        Optional<Account> foundAccount = accountRepository.findById(id);
        if(foundAccount.isPresent()) {
            return AccountResponse.convert(foundAccount.get());
        }

        // TODO throw exception
        return null;
    }

    @Override
    public AccountResponse save(long customerId, Account account) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()) {
            return null; //TODO throw exception
        }

        Customer customer = optionalCustomer.get();
        customer.addAccount(account);
        account.setCustomer(customer);

        return AccountResponse.convert(accountRepository.save(account));
    }

    @Override
    public AccountResponse update(long customerId, Account account) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()) {
            return null; //TODO throw exception
        }
        Customer customer = optionalCustomer.get();
        Account foundAccount = null;

        for(Account acc : customer.getAccounts()) {

            if(acc.getId() == account.getId()) {
                foundAccount = acc;
                break;
            }
        }

        if(foundAccount == null) {
            return null; //TODO throw exception
        }

        int idxFound = customer.getAccounts().indexOf(foundAccount);

        customer.getAccounts().set(idxFound, account);
        account.setCustomer(customer);
        return AccountResponse.convert(accountRepository.save(account));
    }

    @Override
    public AccountResponse delete(long id) {

        AccountResponse accountResponse = findById(id);
        accountRepository.deleteById(accountResponse.getId());
        return accountResponse;
    }


}
