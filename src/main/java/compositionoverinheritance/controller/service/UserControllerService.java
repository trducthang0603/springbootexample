package compositionoverinheritance.controller.service;
import compositionoverinheritance.converter.ModelToResponseConverter;
import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.response.UserResponse;
import compositionoverinheritance.service.PhoneNumberService;
import compositionoverinheritance.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
@Api
@Service
@AllArgsConstructor
public class UserControllerService {

    private final UserService userService;
    private final PhoneNumberService phoneNumberService;
    private final ModelToResponseConverter responseConverter;

    public UserResponse getUserByIdToResponse(
            long userId
    ) {
        UserModel user = userService.getUserById(userId);
        return responseConverter.toResponse(
                user,
                phoneNumberService.getPhoneNumberByUserId(userId)
        );
    }
}
