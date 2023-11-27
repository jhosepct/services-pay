package workshop.stefanini.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.stefanini.transaction.dto.TransactionDTO;
import workshop.stefanini.transaction.entity.Transaction;
import workshop.stefanini.transaction.repository.TransactionRepository;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(int id){
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction saveTransaction(TransactionDTO transaction){
        Transaction transaction1 = new Transaction();
        transaction1.setCustomerId(transaction.getCustomerId());
        transaction1.setAccountId(transaction.getAccountId());
        transaction1.setServiceId(transaction.getServiceId());
        transaction1.setAmount(1000);
        transaction1.setTransactionDate(new Date());

        return transactionRepository.save(transaction1);
    }

    public String deleteTransaction(int id){
        transactionRepository.deleteById(id);
        return "Transaction removed! " + id;
    }

    public List<Transaction> getTransactionByCustomerId(int customerId){
        return transactionRepository.findByCustomerId(customerId);
    }

    public List<Transaction> getTransactionByAccountId(int accountId){
        return transactionRepository.findByAccountId(accountId);
    }

    public List<Transaction> getTransactionByServiceId(int serviceId){
        return transactionRepository.findByServiceId(serviceId);
    }
}
