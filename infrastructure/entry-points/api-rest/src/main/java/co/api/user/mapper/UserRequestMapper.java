package co.api.user.mapper;

import co.api.user.request.RegisterUserRequest;
import co.usecase.user.command.RegisterUserCommand;

public class UserRequestMapper {

    public static RegisterUserCommand toRegisterCommand(RegisterUserRequest registerUserRequest) {
        if(registerUserRequest == null) {
            return null;
        }
        return new RegisterUserCommand(
                registerUserRequest.username(),
                registerUserRequest.email(),
                registerUserRequest.password()
        );
    }
}
