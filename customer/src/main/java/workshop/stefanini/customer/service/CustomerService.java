package workshop.stefanini.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.stefanini.customer.config.RestTemplateConfig;
import workshop.stefanini.customer.dto.TransactionDTO;
import workshop.stefanini.customer.entity.Customer;
import workshop.stefanini.customer.feignClients.TransactionFeignClient;
import workshop.stefanini.customer.model.Transaction;
import workshop.stefanini.customer.repository.CustomerRepository;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestTemplateConfig restTemplate;

    @Autowired
    TransactionFeignClient transactionFeignClient;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "Customer removed! " + id;
    }

    public List<Transaction> getTransactions(int customerId){
        return restTemplate.restTemplate().getForObject("http://localhost:8003/api/v1/transaction/customer/" + customerId, List.class);
    }

    public TransactionDTO saveTransaction(int customerId, TransactionDTO transaction){
        transaction.setCustomerId(customerId);

        return transactionFeignClient.saveTransaction(transaction);
    }

}
