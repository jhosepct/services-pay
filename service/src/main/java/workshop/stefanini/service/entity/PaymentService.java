package workshop.stefanini.service.entity;

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
public class PaymentService {
    @Id
    @GeneratedValue
    private int serviceId;
    private String name;
    private int serviceTypeId;
    private String description;
}
