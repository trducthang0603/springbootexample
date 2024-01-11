package cleancode.v2.convertor;

import cleancode.v2.entity.User;
import cleancode.v2.model.CreateUserModel;
import org.springframework.stereotype.Component;

@Component
public class ModelToEntityConverter {

    public User toEntity(CreateUserModel model) {
        User entity = new User();
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setUsername(model.getUsername());
        entity.setActive(true);
        entity.setEmailVerified(false);
        return entity;
    }
}
