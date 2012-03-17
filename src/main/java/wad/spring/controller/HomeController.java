package wad.spring.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.spring.domain.Course;
import wad.spring.domain.SampleObject;
import wad.spring.domain.User;
import wad.spring.service.CourseService;
import wad.spring.service.CredentialsService;
import wad.spring.service.ObjectFactory;
import wad.spring.service.SecureService;
import wad.spring.service.UserService;

@Controller
public class HomeController {

    @Autowired
    SecureService secureService;
    @Autowired
    ObjectFactory postFilterExample;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CredentialsService credentialsService;

    
    @RequestMapping(value = "/home")
    public String home(Model model) {
        secureService.executeFreely();
        model.addAttribute("students", userService.findAllStudents());
        model.addAttribute("courses", courseService.findAll());
        return "home";
    }
    
    @RequestMapping(value = "/join/{courseId}")
    public String register(Model model, @PathVariable Integer courseId) {
        Course course = courseService.findById(courseId);
        boolean alreadyOnCourse = false;
        String username = credentialsService.getName();
        for(User user : course.getStudents()){
            if(user.getUsername().equals(username)) {
                alreadyOnCourse=true;
                break;
            }
        }
        if(!alreadyOnCourse){
            User student = userService.find(username);
            course.getStudents().add(student);
            courseService.update(course);
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/must-be-authenticated")
    public String mustAuth() {
        secureService.executeOnlyIfAuthenticated();
        return "home";
    }

    @RequestMapping(value = "/must-be-admin")
    public String mustAdmin() {
        secureService.executeOnlyIfAuthenticatedAsLecturer();
        return "home";
    }

    @RequestMapping(value = "/are-they-awesome")
    public String areTheyAwesome(Principal principal) {
        if (principal == null) {
            System.out.println("Not logged in!");
        } else {
            System.out.println("Logged in username, if any: " + principal.getName());
        }

        for (SampleObject obj : postFilterExample.getObjects()) {
            System.out.println("" + obj.isAwesome());
        }

        return "home";
    }
}
