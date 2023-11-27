package workshop.stefanini.transaction.model;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {
    private int transactionId;
    private int customerId;
    private int accountId;
    private int serviceId;
    private float amount;
    private Date transactionDate;
}
