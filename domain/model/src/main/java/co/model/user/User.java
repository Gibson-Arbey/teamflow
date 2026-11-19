package co.model.user;

import co.model.user.valueobject.Email;
import co.model.user.valueobject.Password;
import lombok.Getter;

import java.util.UUID;

@Getter
public class User {

    private final UUID id;
    private final String username;
    private final Email email;
    private final Password password;
    private final UserStatus status;

    private User(UUID id, String username, Email email, Password password, UserStatus status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public  static User create(String username, Email email, Password password, UserStatus status) {
        return  new User(UUID.randomUUID(), username, email, password, status);
    }

    public static  User restore(UUID id, String username, Email email, Password password, UserStatus status) {
        return  new User(id, username, email, password, status);
    }
}
