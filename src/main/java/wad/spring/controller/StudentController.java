package wad.spring.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.spring.domain.User;
import wad.spring.service.CredentialsService;
import wad.spring.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private UserService us;
    @Autowired
    private CredentialsService cs;
    
    @RequestMapping(value = "*")
    public String home(Principal principal, Model model) {
        String username = cs.getName();
        if(cs==null) return "home";
        
        User user = us.find(username);
        model.addAttribute("user", user);
        return "student/home";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String postUsers(@ModelAttribute User user) {
        us.update(user);       
        return "redirect:student";
    }
}
