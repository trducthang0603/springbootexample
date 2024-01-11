package cleancode.v2.controler;

import cleancode.v2.convertor.RequestToModelConverter;

import cleancode.v2.request.RegistrationRequest;
import cleancode.v2.service.AuthService;
import cleancode.v2.validator.AuthValidator;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api
@Controller("/api/v1")
@AllArgsConstructor
public class ApiAuthController {

    private final AuthService authService;
    private final RequestToModelConverter requestToModelConverter;
    private final AuthValidator authValidator;

    //@DoPost("/register")
    @PostMapping("/register")
    public ResponseEntity registerUser(
            @RequestBody RegistrationRequest request
    ) {
        authValidator.validate(request);
        authService.registerUser(
                requestToModelConverter.toModel(request),
                request.isRegisterAsAdmin()
        );
        return  ResponseEntity.noContent().build();
    }
}