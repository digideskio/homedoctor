package wad.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public List<Role> findByRolename(String rolename);
}
