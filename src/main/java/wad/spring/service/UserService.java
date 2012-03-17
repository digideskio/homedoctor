package wad.spring.service;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import wad.spring.domain.User;

public interface UserService {
    
    @PreAuthorize("hasRole('lecturer')")
    public User create(User user);
    
    @PreAuthorize("hasRole('lecturer')")
    public User create(User user, String rolename);
    
    public User find(String username);
    
    public User update(User user);
    
    public List<User> findAllStudents();
}
