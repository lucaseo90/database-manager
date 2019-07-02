package io.github.hsseo0501.databasemanager.service;

import java.sql.ResultSet;
import java.util.List;

public interface QueryExecuteService {
    ResultSet executeQuery(String vendor, String url, String id, String password, String query) throws Exception;

    List<Object> convertResultSetToMap(ResultSet resultSet) throws Exception;
}
