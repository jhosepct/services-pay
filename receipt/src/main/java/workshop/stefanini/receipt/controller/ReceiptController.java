package workshop.stefanini.receipt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workshop.stefanini.receipt.entity.Receipt;
import workshop.stefanini.receipt.service.ReceiptService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/receipt")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @GetMapping()
    public ResponseEntity<List<Receipt>> getAll(){
        List<Receipt> receipts = receiptService.getAll();
        if(receipts.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(receipts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> getReceiptById(@PathVariable("id") int id){
        Receipt receipt = receiptService.getReceiptById(id);
        if(receipt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(receipt);
    }

    @PostMapping()
    public ResponseEntity<Receipt> saveReceipt(@RequestBody Receipt receipt){
        return ResponseEntity.ok(receiptService.saveReceipt(receipt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReceipt(@PathVariable("id") int id){
        return ResponseEntity.ok(receiptService.deleteReceipt(id));
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<List<Receipt>> getReceiptByTransactionId(@PathVariable("transactionId") int transactionId){
        List<Receipt> receipts = receiptService.getReceiptByTransactionId(transactionId);
        if(receipts.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(receipts);
    }
}
