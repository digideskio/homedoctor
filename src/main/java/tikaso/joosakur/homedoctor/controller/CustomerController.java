package tikaso.joosakur.homedoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tikaso.joosakur.homedoctor.service.CredentialsService;
import tikaso.joosakur.homedoctor.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    CredentialsService credentialsService;
    
    @Autowired
    CustomerService customerService;
    
    @RequestMapping(value = "*")
    public String home() {
        return "customer/home";
    }
    
    
}
