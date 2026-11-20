package co.api.user.mapper;

import co.api.user.response.UserResponse;
import co.model.user.User;

public class UserResponseMapper {

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail().value(),
                user.getStatus().name()
        );
    }
}
