package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Role;
import wad.spring.domain.User;
import wad.spring.repository.RoleRepository;
import wad.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CredentialsService credentialsService;

    @Override
    @Transactional
    public User create(User user) {
        if(userRepository.findByUsername(user.getUsername())!=null) return null;
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User create(User user, String rolename) {
        
        Role role = roleService.find(rolename).get(0);
        if(role == null){
            role = new Role();
            role.setRolename(rolename);
        }
        if(user.getRoles()==null) user.setRoles(new ArrayList<Role>());
        user.getRoles().add(role);
        return create(user);
    }

    @Override
    public User find(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public User update(User user) {
        String oldUsername = credentialsService.getName();
        if(!user.getUsername().equals(oldUsername) && find(user.getUsername())!=null) return null; //username already taken
        User oldUser = userRepository.findByUsername(oldUsername);
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        if(user.getRoles()!=null) oldUser.setRoles(user.getRoles());
        return userRepository.save(oldUser);
    }

    @Override
    public List<User> findAllStudents() {
        System.out.println("finding students");
        List<User> users = userRepository.findAll();
        System.out.println("found "+users.size()+" users");
        List<User> students = new ArrayList<User>();
        List<Role> studentRole = roleService.find("student");
        System.out.print("roles found: ");
        System.out.println(studentRole.size());
        System.out.println(roleService.findAll().size());
        for (User user : users){
            boolean ok = false;
            for (Role role : user.getRoles()){
                if(role.getRolename().equals(studentRole.get(0).getRolename())) ok=true;
            }
            if(ok) students.add(user);
        }
        System.out.println("of which "+students.size()+" are students");
        return students;
    }
    
    
}
