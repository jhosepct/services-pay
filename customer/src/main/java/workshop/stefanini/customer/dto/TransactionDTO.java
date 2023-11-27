package workshop.stefanini.customer.dto;

import lombok.Data;

@Data
public class TransactionDTO {
    private int customerId;
    private int accountId;
    private int serviceId;
    private float amount;
}
