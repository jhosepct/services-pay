package workshop.stefanini.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workshop.stefanini.service.entity.PaymentService;
import workshop.stefanini.service.service.ServiceService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @GetMapping()
    public ResponseEntity<List<PaymentService>> getAll(){
        List<PaymentService> services = serviceService.getAll();
        if(services.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentService> getServiceById(@PathVariable("id") int id){
        PaymentService service = serviceService.getServiceById(id);
        if(service == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service);
    }

    @PostMapping()
    public ResponseEntity<PaymentService> saveService(@RequestBody PaymentService service){
        return ResponseEntity.ok(serviceService.saveService(service));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") int id){
        return ResponseEntity.ok(serviceService.deleteService(id));
    }

    @GetMapping("/service-type/{serviceTypeId}")
    public ResponseEntity<List<PaymentService>> getServiceByServiceTypeId(@PathVariable("serviceTypeId") int serviceTypeId){
        List<PaymentService> services = serviceService.getServiceByServiceTypeId(serviceTypeId);
        if(services.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(services);
    }
}
