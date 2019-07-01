package io.github.hsseo0501.databasemanager.service;

import java.sql.Connection;

public interface ConnectionService {
    Connection getConnection(String vendor, String url, String id, String password) throws Exception;
}