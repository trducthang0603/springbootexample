package cleancode.v2.validator;


import cleancode.v2.request.RegistrationRequest;
import cleancode.v2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import spring_redis.exception.HttpBadRequestException;

import java.util.HashMap;
import java.util.Map;

import static org.apache.logging.log4j.util.Strings.isBlank;
@Component
@AllArgsConstructor
public class AuthValidator {

    private final UserService userService;

    public static int MIN_PASSWORD_LENGTH = 6;
    public static int MAX_PASSWORD_LENGTH = 32;

    public static final String PATTERN_USERNAME =
            "[a-zA-Z0-9_]{3,64}";
    public static final String PATTERN_EMAIL =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public void validate(RegistrationRequest request) {
        Map<String, String> errors = new HashMap<>();
        String email = request.getEmail();
        if (isBlank(email)) {
            errors.put("email", "required");
        } else if (!email.matches(PATTERN_EMAIL)) {
            errors.put("email", "invalid");
        }
//        else if (userService.existsUserByEmail(email)) {
//            errors.put("email", "duplicated");
//        }
//        String username = request.getUsername();
//        if (isBlank(username)) {
//            errors.put("username", "required");
//        } else if (!username.matches(PATTERN_USERNAME)) {
//            errors.put("username", "invalid");
//        } else if (userService.existsUserByUsername(username)) {
//            errors.put("username", "duplicated");
//        }
        String password = request.getPassword();
        if (isBlank(password)) {
            errors.put("password", "required");
        } else if (password.length() < MIN_PASSWORD_LENGTH) {
            errors.put("password", "tooShort");
        } else if (password.length() > MAX_PASSWORD_LENGTH) {
            errors.put("password", "overLength");
        }
        if (errors.size() > 0) {

            throw new HttpBadRequestException(errors.toString());
        }
    }
}
