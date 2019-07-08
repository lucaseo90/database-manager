package io.github.hsseo0501.databasemanager.repository.auth;

import io.github.hsseo0501.databasemanager.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
