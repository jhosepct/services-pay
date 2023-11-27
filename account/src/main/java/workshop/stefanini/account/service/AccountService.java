package workshop.stefanini.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.stefanini.account.entity.Account;
import workshop.stefanini.account.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Account getAccountById(int id){
        return accountRepository.findById(id).orElse(null);
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public String deleteAccount(int id){
        accountRepository.deleteById(id);
        return "Account removed! " + id;
    }

    public List<Account> getAccountByCustomerId(int customerId){
        return accountRepository.findByCustomerId(customerId);
    }
}
