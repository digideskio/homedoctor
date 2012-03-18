package tikaso.joosakur.homedoctor.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomedoctorUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password="";
        String rolename="";
        
        if(customerService.find(username)!=null){
            password = customerService.find(username).getPassword();
            rolename = "customer";
        }
        else {
            throw new UsernameNotFoundException("Didn't find username "+username);
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(rolename));
        
        return new org.springframework.security.core.userdetails.User(username, password, true, true, true, true, authorities);
    }
    
}
