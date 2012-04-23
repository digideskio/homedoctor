package tikaso.joosakur.homedoctor.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tikaso.joosakur.homedoctor.domain.Customer;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Reservation;
import tikaso.joosakur.homedoctor.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;
    
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

    @Override
    public List<Customer> findCustomers(Doctor doctor) {
        Set<Customer> customerSet = new HashSet<Customer>();
        for(Reservation reservation : doctor.getReservations()){
            customerSet.add(reservation.getCustomer());
        }
        List<Customer> customers = new ArrayList<Customer>(customerSet);
        Collections.sort(customers, new AlphabeticalOrder());
        
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    private static class AlphabeticalOrder implements Comparator<Customer>{

        @Override
        public int compare(Customer o1, Customer o2) {
            int lastname = o1.getLastName().compareToIgnoreCase(o2.getLastName());
            if(lastname!=0) return lastname;
            else return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
        }
        
    }
}
