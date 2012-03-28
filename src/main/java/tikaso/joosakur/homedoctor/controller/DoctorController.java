package tikaso.joosakur.homedoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tikaso.joosakur.homedoctor.service.CredentialsService;
import tikaso.joosakur.homedoctor.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    
    @Autowired
    private CredentialsService credentialsService;
    
    @Autowired
    private DoctorService doctorService;
    
    @RequestMapping(value = "*")
    public String home() {
        return "doctor/home";
    }
    
    
}
