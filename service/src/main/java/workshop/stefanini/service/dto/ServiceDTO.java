package workshop.stefanini.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private int serviceId;
    private String name;
    private int serviceTypeId;
    private String description;
}
