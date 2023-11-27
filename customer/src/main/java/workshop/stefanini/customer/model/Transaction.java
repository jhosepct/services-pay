package workshop.stefanini.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int customerId;
    private int accountId;
    private int serviceId;
    private float amount;
    private Date transactionDate;
}
