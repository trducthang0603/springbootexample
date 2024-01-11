package cleancode.v1.service;

import cleancode.v1.exception.ResourceAlreadyInUseException;
import cleancode.v1.model.User;
import cleancode.v1.model.payload.RegistrationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Registers a new user in the database by performing a series of quick checks.
     *
     * @return A user object if successfully created
     */
    public Optional<User> registerUser(RegistrationRequest newRegistrationRequest) {
        String newRegistrationRequestEmail = newRegistrationRequest.getEmail();
//        if (emailAlreadyExists(newRegistrationRequestEmail)) {
//            logger.error("Email already exists: " + newRegistrationRequestEmail);
//            throw new ResourceAlreadyInUseException("Email", "Address", newRegistrationRequestEmail);
//        }
        logger.info("Trying to register new user [" + newRegistrationRequestEmail + "]");
        User newUser = userService.createUser(newRegistrationRequest);
        User registeredNewUser = userService.save(newUser);
        return Optional.ofNullable(registeredNewUser);
    }

    /**
     * Checks if the given email already exists in the database repository or not
     *
     * @return true if the email exists else false
     */
//    public Boolean emailAlreadyExists(String email) {
//        return userService.existsByEmail(email);
//    }
}