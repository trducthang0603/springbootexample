package cleancode.v2.convertor;

import cleancode.v2.model.CreateUserModel;
import cleancode.v2.request.RegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestToModelConverter {

    public CreateUserModel toModel(
            RegistrationRequest request
    ) {
        return CreateUserModel
                .builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(request.getPassword())
                .build();
    }
}
