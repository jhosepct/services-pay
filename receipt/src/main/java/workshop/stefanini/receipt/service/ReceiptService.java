package workshop.stefanini.receipt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.stefanini.receipt.entity.Receipt;
import workshop.stefanini.receipt.repository.ReceiptRepository;

import java.util.List;

@Service
public class ReceiptService {

    @Autowired
    ReceiptRepository receiptRepository;

    public List<Receipt> getAll(){
        return receiptRepository.findAll();
    }

    public Receipt getReceiptById(int id){
        return receiptRepository.findById(id).orElse(null);
    }

    public Receipt saveReceipt(Receipt receipt){
        return receiptRepository.save(receipt);
    }

    public String deleteReceipt(int id){
        receiptRepository.deleteById(id);
        return "Receipt removed! " + id;
    }

    public List<Receipt> getReceiptByTransactionId(int transactionId){
        return receiptRepository.findByTransactionId(transactionId);
    }
}
