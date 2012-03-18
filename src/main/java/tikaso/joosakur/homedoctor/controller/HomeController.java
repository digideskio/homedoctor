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
import tikaso.joosakur.homedoctor.formvalidation.CustomerFormObject;
import tikaso.joosakur.homedoctor.service.CredentialsService;
import tikaso.joosakur.homedoctor.service.CustomerService;

@Controller
public class HomeController {
    
    @Autowired
    CredentialsService credentialsService;
    
    @Autowired
    CustomerService customerService;
    
    @RequestMapping(value = "*")
    public String home() {
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
        
        Customer customer = new Customer();
        customer.setFirstName(formObj.getFirstName());
        customer.setLastName(formObj.getLastName());
        customer.setCity(formObj.getCity());
        customer.setStreetAddress(formObj.getStreetAddress());
        customer.setPhoneNumber(formObj.getPhoneNumber());
        customer.setDayBorn(formObj.getDayBorn());
        customer.setMonthBorn(formObj.getMonthBorn());
        customer.setYearBorn(formObj.getYearBorn());
        customer.setPassword(formObj.getPassword());
        customer = customerService.createOrUpdate(customer);
        customer.solveCustomerNumberAndUsername();
        customer = customerService.createOrUpdate(customer);
        
        model.addAttribute("customerNumber", customer.getCustomerNro());
        return "home/registercomplete";
    }

    /*@RequestMapping(value="registercomplete", method= RequestMethod.GET)
    public String registerComplete(){
        
    }*/
    
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        if(customerService.find(credentialsService.getName())!=null) return "redirect:customer/home";
        return "home/login";
        
    }
    
    
}
