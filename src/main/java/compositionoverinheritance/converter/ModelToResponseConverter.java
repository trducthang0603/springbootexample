package compositionoverinheritance.converter;

import compositionoverinheritance.model.UserModel;
import compositionoverinheritance.response.UserResponse;

public class ModelToResponseConverter {

    public UserResponse toResponse(
            UserModel model
    ) {
        return UserResponse
                .builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    public UserResponse toResponse(
            UserModel model,
            String phoneNumber
    ) {
        return UserResponse
                .builder()
                .id(model.getId())
                .name(model.getName())
                .phoneNumber(phoneNumber)
                .build();
    }
}
