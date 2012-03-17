package wad.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.spring.domain.Course;
import wad.spring.domain.User;
import wad.spring.service.CourseService;
import wad.spring.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping(value = "*")
    public String home() {
        return "admin/home";
    }
    
    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String getUsers() {
        return "admin/students";
    }
    
    @RequestMapping(value = "students", method = RequestMethod.POST)
    public String postUsers(@ModelAttribute User user) {
        userService.create(user, "student");
        return "redirect:/admin/";
    }
    
    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public String getCourses() {
        return "admin/courses";
    }
    
    @RequestMapping(value = "courses", method = RequestMethod.POST)
    public String postUsers(@ModelAttribute Course course) {
        courseService.create(course);
        return "redirect:/admin/";
    }
    
    
}
