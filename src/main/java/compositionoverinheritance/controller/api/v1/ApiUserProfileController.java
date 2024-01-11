package compositionoverinheritance.controller.api.v1;
import compositionoverinheritance.converter.ModelToResponseConverter;
import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.request.UpdateUserRequest;
import compositionoverinheritance.response.UserResponse;
import compositionoverinheritance.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api
@Controller("/api/v1")
@AllArgsConstructor
public class ApiUserProfileController {

    private UserService userService;
    private ModelToResponseConverter responseConverter;

    @PutMapping("/users/{userId}")
    public UserResponse usersUserIdPut(
            @PathVariable long userId,
            @RequestBody UpdateUserRequest request
    ) {
        userService.updateUser(
                userId,
                request.getName()
        );
        return getUserByIdToResponse(
                userId
        );
    }

    private UserResponse getUserByIdToResponse(
            long userId
    ) {
        UserModel user = userService.getUserById(userId);
        return responseConverter.toResponse(user);
    }
}
