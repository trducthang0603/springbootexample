package cleancode.v2.service;

import cleancode.v2.entity.Role;
import cleancode.v2.entity.RoleName;
import cleancode.v2.repo.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Long> getAllRoleIds(
            boolean includeAdminRole
    ) {
        return roleRepository
                .findAll()
                .stream()
                .filter(
                        role -> {
                            if (includeAdminRole) {
                                return true;
                            } else {
                                return !RoleName.ROLE_ADMIN.equals(role.getName());
                            }
                        }
                )
                .map(Role::getId)
                .collect(Collectors.toList());
    }
}