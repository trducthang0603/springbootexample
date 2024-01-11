package compositionoverinheritance.controller.api.v4;
import compositionoverinheritance.controller.service.UserControllerService;
import compositionoverinheritance.converter.ModelToResponseConverter;
import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.request.UpdateUserRequest;
import compositionoverinheritance.response.UserResponse;
import compositionoverinheritance.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api
@Controller("/api/v1")
@AllArgsConstructor
public class ApiUserProfileController {

    private final UserService userService;
    private final UserControllerService userControllerService;

    @PutMapping("/users/{userId}")
    public UserResponse usersUserIdPut(
            @PathVariable long userId,
            @RequestBody UpdateUserRequest request
    ) {
        userService.updateUser(
                userId,
                request.getName()
        );
        return userControllerService.getUserByIdToResponse(
                userId
        );
    }
}