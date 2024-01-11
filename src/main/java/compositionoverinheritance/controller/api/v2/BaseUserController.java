package compositionoverinheritance.controller.api.v2;
import compositionoverinheritance.converter.ModelToResponseConverter;
import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.response.UserResponse;
import compositionoverinheritance.service.UserService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BaseUserController {

    protected UserService userService;
    protected ModelToResponseConverter responseConverter;

    protected UserResponse getUserByIdToResponse(
            long userId
    ) {
        UserModel user = userService.getUserById(userId);
        return responseConverter.toResponse(user);
    }
}
