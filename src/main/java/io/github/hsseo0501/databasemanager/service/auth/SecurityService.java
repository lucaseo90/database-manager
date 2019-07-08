package io.github.hsseo0501.databasemanager.service.auth;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
