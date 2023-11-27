package workshop.stefanini.servicetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workshop.stefanini.servicetype.entity.ServiceType;

import java.util.List;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
