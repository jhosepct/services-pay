package workshop.stefanini.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private int customer_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String last_name;
    @Column(length = 8, unique = true, nullable = false)
    private String dni;
    @Column(length = 9)
    private String phone_number;
    @Column(unique = true)
    private String email;
    private String password;
}
