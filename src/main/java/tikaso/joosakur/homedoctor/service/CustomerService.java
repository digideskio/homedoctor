package tikaso.joosakur.homedoctor.service;

import java.util.List;
import tikaso.joosakur.homedoctor.domain.Customer;
import tikaso.joosakur.homedoctor.domain.Doctor;

public interface CustomerService {
    
    public Customer createOrUpdate(Customer customer);
        
    public Customer find(String username);
    
    public Customer findById(Long id);
    
    public List<Customer> findAllCustomers();
    
    public List<Customer> findCustomers(Doctor doctor);
    
    
}
