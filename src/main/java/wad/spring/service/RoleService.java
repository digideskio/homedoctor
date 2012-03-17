package wad.spring.service;


import java.util.List;
import wad.spring.domain.Role;

public interface RoleService {
    public List<Role> findAll();
    public List<Role> find(String rolename);
}
