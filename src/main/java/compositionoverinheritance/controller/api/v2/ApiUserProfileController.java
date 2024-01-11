package compositionoverinheritance.controller.api.v2;
import compositionoverinheritance.converter.ModelToResponseConverter;
import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.request.UpdateUserRequest;
import compositionoverinheritance.response.UserResponse;
import compositionoverinheritance.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api
@Controller("/api/v1")
public class ApiUserProfileController extends BaseUserController {

    public ApiUserProfileController(
            UserService userService,
            ModelToResponseConverter responseConverter
    ) {
        super(userService, responseConverter);
    }

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
}
