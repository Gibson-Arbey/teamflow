package co.usecase.user;

import co.model.shared.FileResource;
import co.model.user.User;
import co.model.user.gateways.UserRepository;
import co.usecase.user.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class RegisterUserUseCase {

    private final UserRepository userRepository;

    public User execute(RegisterUserCommand command, FileResource userImage){
        // Implementation for registering a new user
        return null;
    }
}
