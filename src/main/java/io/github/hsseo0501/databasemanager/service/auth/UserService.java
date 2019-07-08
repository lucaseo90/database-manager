package io.github.hsseo0501.databasemanager.service.auth;

import io.github.hsseo0501.databasemanager.model.auth.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
