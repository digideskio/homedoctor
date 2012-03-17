package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.spring.domain.Role;
import wad.spring.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> find(String rolename) {
        return roleRepository.findByRolename(rolename);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    
    
}
