package workshop.stefanini.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import workshop.stefanini.transaction.dto.TransactionDTO;
import workshop.stefanini.transaction.entity.Transaction;
import workshop.stefanini.transaction.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public ResponseEntity<List<Transaction>> getAll(){
        List<Transaction> transactions = transactionService.getAll();
        if(transactions.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") int id){
        Transaction transaction = transactionService.getTransactionById(id);
        if(transaction == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transaction);
    }

    @PostMapping()
    public ResponseEntity<Transaction> saveTransaction(@RequestBody TransactionDTO transaction){
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") int id){
        return ResponseEntity.ok(transactionService.deleteTransaction(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactionByCustomerId(@PathVariable("customerId") int customerId){
        List<Transaction> transactions = transactionService.getTransactionByCustomerId(customerId);
        if(transactions.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionByAccountId(@PathVariable("accountId") int accountId){
        List<Transaction> transactions = transactionService.getTransactionByAccountId(accountId);
        if(transactions.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/service/{serviceId}")
    public ResponseEntity<List<Transaction>> getTransactionByServiceId(@PathVariable("serviceId") int serviceId){
        List<Transaction> transactions = transactionService.getTransactionByServiceId(serviceId);
        if(transactions.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactions);
    }
}
