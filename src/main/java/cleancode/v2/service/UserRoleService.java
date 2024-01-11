package cleancode.v2.service;

import cleancode.v2.entity.UserRole;
import cleancode.v2.repo.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserRoleService {

    private final RoleService roleService;
    private final UserRoleRepository userRoleRepository;

    public void addRolesToNewUser(
            long newUserId,
            boolean asAdmin
    ) {
        addUserRoles(
                newUserId,
                roleService.getAllRoleIds(
                        asAdmin
                )
        );
    }

    private void addUserRoles(
            long userId,
            Collection<Long> roleIds
    ) {
        List<UserRole> userRoles = roleIds.stream()
                .map(roleId -> new UserRole(userId, roleId))
                .collect(Collectors.toList());
        userRoleRepository.saveAll(userRoles);
    }
}
