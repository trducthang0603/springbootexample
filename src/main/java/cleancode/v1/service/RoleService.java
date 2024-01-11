package cleancode.v1.service;

import cleancode.v1.model.Role;
import cleancode.v1.repo.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Find all roles from the database
     */
    public Collection<Role> findAll() {
        return (Collection<Role>) roleRepository.findAll();
    }
}
