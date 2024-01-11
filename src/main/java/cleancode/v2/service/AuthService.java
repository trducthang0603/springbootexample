package cleancode.v2.service;

import cleancode.v2.entity.User;
import cleancode.v2.model.CreateUserModel;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserService userService;

    public void registerUser(
            CreateUserModel model,
            boolean asAdmin
    ) {
        userService.createUser(model, asAdmin);
    }
}