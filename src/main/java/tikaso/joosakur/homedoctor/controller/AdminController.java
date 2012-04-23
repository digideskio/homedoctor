package tikaso.joosakur.homedoctor.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.formvalidation.DoctorFormObject;
import tikaso.joosakur.homedoctor.service.DoctorService;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {
    
    @Autowired
    private DoctorService doctorService;
    
    
    @RequestMapping(value = "*")
    public String other(Model model) {
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("doctors", doctorService.findAllDoctors());
        return "admin/home";
    }

    
    
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new DoctorFormObject());
        return "admin/register";
    }
    
    @RequestMapping(value = "register", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("user") DoctorFormObject formObj, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "admin/register";
        
        Doctor doctor = new Doctor(formObj);
        doctor = doctorService.createOrUpdate(doctor);
        
        return "redirect:home";
    }

}
