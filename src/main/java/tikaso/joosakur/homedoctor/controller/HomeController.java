package tikaso.joosakur.homedoctor.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tikaso.joosakur.homedoctor.domain.Customer;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.formvalidation.CustomerFormObject;
import tikaso.joosakur.homedoctor.service.CredentialsService;
import tikaso.joosakur.homedoctor.service.CustomerService;
import tikaso.joosakur.homedoctor.service.DoctorService;

@Controller
public class HomeController {
    
    @Autowired
    private CredentialsService credentialsService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private DoctorService doctorService;
    
    private static boolean initialized = false;

    @RequestMapping(value = "*")
    public String any() {
        return "redirect:home";
    }
    
    @RequestMapping(value = "home")
    public String home() {
        if(!initialized) initialize();
        
        return "home/home";
    }
    
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new CustomerFormObject());
        return "home/register";
    }
    
    @RequestMapping(value = "register", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("user") CustomerFormObject formObj, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) return "home/register";
        
        Customer customer = new Customer(formObj);
        customer = customerService.createOrUpdate(customer);
        customer.solveCustomerNumberAndUsername();
        customer = customerService.createOrUpdate(customer);
        
        model.addAttribute("customerNumber", customer.getCustomerNro());
        return "home/registercomplete";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        if(customerService.find(credentialsService.getName())!=null) return "redirect:customer/home";
        if(doctorService.find(credentialsService.getName())!=null) return "redirect:doctor/home";
        return "home/login";
        
    }
    
    @RequestMapping(value = "/admin")
    public String admin() {
        return "redirect:admin/home";
    }

    private void initialize() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Matti");
        doctor.setLastName("Virtanen");
        doctor.setUsername("masa");
        doctor.setPassword("aabbcc");
        doctorService.createOrUpdate(doctor);
        
        doctor = new Doctor();
        doctor.setFirstName("Pekka");
        doctor.setLastName("Halonen");
        doctor.setUsername("peku");
        doctor.setPassword("aabbcc");
        doctorService.createOrUpdate(doctor);
        
        Customer customer = new Customer();
        customer.setFirstName("Joosa");
        customer.setLastName("Kurvinen");
        customer.setDayBorn(7);
        customer.setMonthBorn(1);
        customer.setYearBorn(1990);
        customer.setCity("Helsinki");
        customer.setStreetAddress("katu 8");
        customer.setPhoneNumber("0504139432");
        customer.setPassword("aabbcc");
        customer = customerService.createOrUpdate(customer);
        customer.solveCustomerNumberAndUsername();
        customer = customerService.createOrUpdate(customer);
        initialized=true;
        
    }
    
}
