package co.api.user;

import co.api.config.ApiPath;
import co.api.shared.converter.FileResourceConverter;
import co.api.shared.converter.JsonConverter;
import co.api.user.mapper.UserRequestMapper;
import co.api.user.mapper.UserResponseMapper;
import co.api.user.request.RegisterUserRequest;
import co.api.user.response.UserResponse;
import co.model.shared.FileResource;
import co.usecase.user.RegisterUserUseCase;
import co.usecase.user.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ApiPath.ROUTE_USER, version = ApiPath.V1)
public class UserApiRest {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UserResponse> registerUser(@RequestParam(name = "registerUserRequest") String registerUserRequest, @RequestParam(name = "userImage") MultipartFile userImage) {
        RegisterUserRequest request = JsonConverter.toObject(registerUserRequest, RegisterUserRequest.class);
        FileResource fileResource = FileResourceConverter.toFileResource(userImage);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                UserResponseMapper.toResponse(
                        registerUserUseCase.execute(UserRequestMapper.toRegisterCommand(request), fileResource)
                )
        );
    }
}
