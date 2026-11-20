package co.model.user;

import co.model.shared.FileResource;
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
    private final FileResource userImage;

    private User(UUID id, String username, Email email, Password password, UserStatus status, FileResource userImage) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.userImage = userImage;
    }

    public  static User create(String username, Email email, Password password, UserStatus status, FileResource userImage) {
        return  new User(UUID.randomUUID(), username, email, password, status, userImage);
    }

    public static  User restore(UUID id, String username, Email email, Password password, UserStatus status, FileResource userImage) {
        return  new User(id, username, email, password, status, userImage);
    }
}
