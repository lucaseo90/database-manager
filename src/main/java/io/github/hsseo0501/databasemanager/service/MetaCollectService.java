package io.github.hsseo0501.databasemanager.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface MetaCollectService {

    ResultSet getColumns(Connection connection, String tableName);

    ResultSet getPrimaryKeys(Connection connection, String tableName);

    List<String> getSQLKeywords(Connection connection);

    ResultSet getStoredProcedures(Connection connection, String catalog, String schemaPattern, String procedureNamePattern);

    List<String> getTableNames(Connection connection);

    Map<String, String> getTablesAndViews(Connection connection);

    List<String> getTableTypes(Connection connection);

    List<String> getViewNames(Connection connection);

}
