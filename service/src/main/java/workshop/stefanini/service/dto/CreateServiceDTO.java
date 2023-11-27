package workshop.stefanini.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class CreateServiceDTO {
    private String name;
    private int serviceTypeId;
    private String description;
}
