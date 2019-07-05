package io.github.hsseo0501.databasemanager.service;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class QueryExecuteServiceImpl implements QueryExecuteService {
    static final String DB_VENDOR_POSTGRESQL = "postgresql";
    static final String JDBC_DRIVER_POSTGRESQL = "org.postgresql.Driver";

    @Override
    public ResultSet executeQuery(String vendor, String url, String id, String password, String query) throws Exception {
        ResultSet resultSet;
        if (vendor.equalsIgnoreCase(DB_VENDOR_POSTGRESQL)) {
            Class.forName(JDBC_DRIVER_POSTGRESQL);
            Connection connection = DriverManager.getConnection(url, id, password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } else {
            throw new Exception("unknown db vendor");
        }
        return resultSet;
    }

    @Override
    public List<Object> convertResultSetToList(ResultSet resultSet) throws Exception {
        List<Object> data = new LinkedList<>();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        while (resultSet.next()) {
            HashMap<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                row.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            data.add(row);
        }
        return data;
    }
}
