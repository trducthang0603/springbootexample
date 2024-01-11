package cleancode.v1.controler;

import cleancode.v1.event.ApplicationEventPublisher;
import cleancode.v1.event.OnUserRegistrationCompleteEvent;
import cleancode.v1.exception.UserRegistrationException;
import cleancode.v1.model.payload.ApiResponse;
import cleancode.v1.model.payload.RegistrationRequest;
import cleancode.v1.service.AuthService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api
@Controller
public class ApiAuthController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final AuthService authService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ApiAuthController(AuthService authService, ApplicationEventPublisher applicationEventPublisher) {
        this.authService = authService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    //@DoPost("/register")
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody
                                       RegistrationRequest registrationRequest) {

        return authService.registerUser(registrationRequest)
                .map(user -> {
                    String redirectUrl = "/api" +
                            "/auth/registrationConfirmation";
                    OnUserRegistrationCompleteEvent onUserRegistrationCompleteEvent =
                            new OnUserRegistrationCompleteEvent(user, redirectUrl);
                    applicationEventPublisher.publishEvent(onUserRegistrationCompleteEvent);
                    logger.info("Registered User returned [API[: " + user);
                    return ResponseEntity.ok(new ApiResponse(true, "User registered successfully. Check your email " +
                            "for verification"));
                })
                .orElseThrow(() -> new UserRegistrationException(registrationRequest.getEmail(), "Missing user object" +
                        " in database"));
    }

}