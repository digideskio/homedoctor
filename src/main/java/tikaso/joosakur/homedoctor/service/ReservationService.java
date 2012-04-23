package tikaso.joosakur.homedoctor.service;

import java.util.List;
import tikaso.joosakur.homedoctor.domain.Customer;

public interface CustomerService {
    
    public Customer createOrUpdate(Customer customer);
        
    public Customer find(String username);
    
    public List<Customer> findAllCustomers();
}
