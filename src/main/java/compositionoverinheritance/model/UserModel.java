package compositionoverinheritance.model;
import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class UserModel {
    private long id;
    private String name;
}
