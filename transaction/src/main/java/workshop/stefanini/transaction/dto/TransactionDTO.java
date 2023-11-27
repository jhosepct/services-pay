package workshop.stefanini.transaction.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO {
    private int customerId;
    private int accountId;
    private int serviceId;
    private float amount;
}
