package io.github.hsseo0501.databasemanager.repository.auth;

import io.github.hsseo0501.databasemanager.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
