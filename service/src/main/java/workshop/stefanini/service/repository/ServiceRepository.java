package workshop.stefanini.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workshop.stefanini.service.entity.PaymentService;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<PaymentService, Integer> {
    List<PaymentService> findByServiceTypeId(int serviceTypeId);
}
