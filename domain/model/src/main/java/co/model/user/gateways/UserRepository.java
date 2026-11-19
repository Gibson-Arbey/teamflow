package co.model.user.gateways;

import co.model.user.User;

import java.util.UUID;

public interface UserRepository {

    User save(User user);

    User findById(UUID id);

    User findByEmail(String email);

    boolean existsById(UUID id);

    void updateStatus(UUID id, String status);
}
