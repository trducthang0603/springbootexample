package compositionoverinheritance.controller.api.v4;
import compositionoverinheritance.controller.service.UserControllerService;
import compositionoverinheritance.converter.ModelToResponseConverter;
import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.response.UserResponse;
import compositionoverinheritance.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Api
@Controller("/api/v1")
@AllArgsConstructor
public class ApiUserManagementController {

    private final UserService userService;
    private final UserControllerService userControllerService;

    @PutMapping("/user-management/latest-user")
    public UserResponse userManagementLatestUserGet() {
        long latestUserId = userService.getLatestUserId();
        return userControllerService.getUserByIdToResponse(
                latestUserId
        );
    }
}
