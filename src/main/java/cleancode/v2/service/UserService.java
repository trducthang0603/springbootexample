package cleancode.v2.service;

import cleancode.v2.convertor.ModelToEntityConverter;
import cleancode.v2.entity.Role;
import cleancode.v2.entity.User;
import cleancode.v2.model.CreateUserModel;
import cleancode.v2.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;

    private final ModelToEntityConverter modelToEntityConverter;

    public void createUser(
            CreateUserModel model,
            boolean asAdmin
    ) {
        User entity = modelToEntityConverter.toEntity(model);
        userRepository.save(entity);
        userRoleService.addRolesToNewUser(
                entity.getId(),
                asAdmin
        );
    }

//    public boolean existsUserByEmail(String email) {
//        return userRepository.containsByField(
//                "email",
//                email
//        );
//    }

//    public boolean existsUserByUsername(String username) {
//        return userRepository.containsByField(
//                "username",
//                username
//        );
//    }
}