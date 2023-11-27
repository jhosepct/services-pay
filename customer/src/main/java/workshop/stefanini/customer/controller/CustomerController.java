package workshop.stefanini.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workshop.stefanini.customer.dto.TransactionDTO;
import workshop.stefanini.customer.entity.Customer;
import workshop.stefanini.customer.model.Transaction;
import workshop.stefanini.customer.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customers = customerService.getAll();
        if(customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
        Customer customer = customerService.getCustomerById(id);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @GetMapping("/transaction/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable("customerId") int customerId){
        Customer customer = customerService.getCustomerById(customerId);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }

        List<Transaction> transactions = customerService.getTransactions(customerId);
        if(transactions.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/transaction/{customerId}")
    public ResponseEntity<TransactionDTO> saveTransaction(@PathVariable("customerId") int customerId, @RequestBody TransactionDTO transaction){
        TransactionDTO transactionNew = customerService.saveTransaction(customerId, transaction);
        return ResponseEntity.ok(transactionNew);
    }

}
