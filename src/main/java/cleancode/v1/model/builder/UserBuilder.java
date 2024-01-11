package cleancode.v1.model.builder;

import cleancode.v1.model.Role;
import cleancode.v1.model.User;
import cleancode.v1.model.Builder;

import java.util.HashSet;
import java.util.Set;

public class UserBuilder implements Builder<User> {
    private int id;
    private String email;
    private String username;
    private String password;
    private String fistname;
    private String lastname;
    private Boolean active;
    private Set<Role> roles = new HashSet<>();
    private Boolean isEMailVerify;
    public UserBuilder id(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.username = name;
        return this;
    }
    @Override
    public User build() {
        final User user = new User();
        //user.setId(id);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(fistname);
        user.setLastName(lastname);
        user.setActive(active);
        user.setRoles(roles);
        //user.setIsEMailVerify(isEMailVerify);
        return user;
    }
}
