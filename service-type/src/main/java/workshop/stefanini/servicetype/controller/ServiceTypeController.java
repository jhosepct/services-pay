package workshop.stefanini.servicetype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workshop.stefanini.servicetype.entity.ServiceType;
import workshop.stefanini.servicetype.service.ServiceTypeService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/service-type")
public class ServiceTypeController {
    @Autowired
    ServiceTypeService serviceTypeService;

    @GetMapping()
    public ResponseEntity<List<ServiceType>> getAll(){
        List<ServiceType> serviceTypes = serviceTypeService.getAll();
        if(serviceTypes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(serviceTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceType> getServiceTypeById(@PathVariable("id") int id){
        ServiceType serviceType = serviceTypeService.getServiceTypeById(id);
        if(serviceType == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(serviceType);
    }

    @PostMapping()
    public ResponseEntity<ServiceType> saveServiceType(@RequestBody ServiceType serviceType){
        return ResponseEntity.ok(serviceTypeService.saveServiceType(serviceType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServiceType(@PathVariable("id") int id){
        return ResponseEntity.ok(serviceTypeService.deleteServiceType(id));
    }
}
