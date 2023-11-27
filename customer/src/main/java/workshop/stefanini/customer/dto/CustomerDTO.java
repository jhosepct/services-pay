package workshop.stefanini.customer.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private int id;
    private String name;
    private String lastName;
    private String dni;
    private String phoneNumber;
    private String email;
    private String password;

}
