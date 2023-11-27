package workshop.stefanini.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workshop.stefanini.account.entity.Account;
import workshop.stefanini.account.service.AccountService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping()
    public ResponseEntity<List<Account>> getAll(){
        List<Account> accounts = accountService.getAll();
        if(accounts.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") int id){
        Account account = accountService.getAccountById(id);
        if(account == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @PostMapping()
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.saveAccount(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") int id){
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Account>> getAccountByCustomerId(@PathVariable("customerId") int customerId){
        List<Account> accounts = accountService.getAccountByCustomerId(customerId);
        if(accounts.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accounts);
    }
}
