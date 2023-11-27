package workshop.stefanini.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workshop.stefanini.transaction.entity.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByCustomerId(int customerId);
    List<Transaction> findByAccountId(int accountId);
    List<Transaction> findByServiceId(int serviceId);
}
