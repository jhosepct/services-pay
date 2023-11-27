package workshop.stefanini.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.stefanini.service.entity.PaymentService;
import workshop.stefanini.service.repository.ServiceRepository;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    public List<PaymentService> getAll(){
        return serviceRepository.findAll();
    }

    public PaymentService getServiceById(int id){
        return serviceRepository.findById(id).orElse(null);
    }

    public PaymentService saveService(PaymentService service){
        return serviceRepository.save(service);
    }

    public String deleteService(int id){
        serviceRepository.deleteById(id);
        return "Service removed! " + id;
    }

    public List<PaymentService> getServiceByServiceTypeId(int serviceTypeId){
        return serviceRepository.findByServiceTypeId(serviceTypeId);
    }
}
