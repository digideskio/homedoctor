package tikaso.joosakur.homedoctor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tikaso.joosakur.homedoctor.domain.Customer;
import tikaso.joosakur.homedoctor.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CredentialsService credentialsService;

    @Override
    @Transactional
    public Customer createOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer find(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

}
