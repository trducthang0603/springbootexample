package compositionoverinheritance.controller.api.v2;
import compositionoverinheritance.converter.ModelToResponseConverter;
import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.response.UserResponse;
import compositionoverinheritance.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Api
@Controller("/api/v1")
public class ApiUserManagementController extends BaseUserController {

    public ApiUserManagementController(
            UserService userService,
            ModelToResponseConverter responseConverter
    ) {
        super(userService, responseConverter);
    }

    @GetMapping("/user-management/latest-user")
    public UserResponse userManagementLatestUserGet() {
        long latestUserId = userService.getLatestUserId();
        return getUserByIdToResponse(latestUserId);
    }
}
