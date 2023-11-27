package workshop.stefanini.servicetype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.stefanini.servicetype.entity.ServiceType;
import workshop.stefanini.servicetype.repository.ServiceTypeRepository;

import java.util.List;

@Service
public class ServiceTypeService {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public List<ServiceType> getAll(){
        return serviceTypeRepository.findAll();
    }

    public ServiceType getServiceTypeById(int id){
        return serviceTypeRepository.findById(id).orElse(null);
    }

    public ServiceType saveServiceType(ServiceType serviceType){
        return serviceTypeRepository.save(serviceType);
    }

    public String deleteServiceType(int id){
        serviceTypeRepository.deleteById(id);
        return "ServiceType removed! " + id;
    }
}
