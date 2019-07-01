package io.github.hsseo0501.databasemanager.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    static final String DB_VENDOR_POSTGRESQL = "postgresql";
    static final String JDBC_DRIVER_POSTGRESQL = "org.postgresql.Driver";

    public Connection getConnection(String vendor, String url, String id, String password) throws Exception {
        if (vendor.equalsIgnoreCase(DB_VENDOR_POSTGRESQL)) {
            Class.forName(JDBC_DRIVER_POSTGRESQL);
            return DriverManager.getConnection(url, id, password);
        } else {
            throw new Exception("unknown db vendor");
        }
    }
}
