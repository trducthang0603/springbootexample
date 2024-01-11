package compositionoverinheritance.controller.api.v1;

import compositionoverinheritance.converter.ModelToResponseConverter;
import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.response.UserResponse;
import compositionoverinheritance.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Api
@Controller("/api/v1")
@AllArgsConstructor
public class ApiUserManagementController {

    private UserService userService;
    private ModelToResponseConverter responseConverter;

    @PostMapping("/user-management/latest-user")
    public UserResponse userManagementLatestUserGet() {
        long latestUserId = userService.getLatestUserId();
        return getUserByIdToResponse(latestUserId);
    }

    private UserResponse getUserByIdToResponse(
            long userId
    ) {
        UserModel user = userService.getUserById(userId);
        return responseConverter.toResponse(user);
    }
}
