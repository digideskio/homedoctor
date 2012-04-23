package tikaso.joosakur.homedoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tikaso.joosakur.homedoctor.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByUsername(String username);
}
