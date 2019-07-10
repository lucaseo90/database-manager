package io.github.hsseo0501.databasemanager.service;

import io.github.hsseo0501.databasemanager.model.Column;
import io.github.hsseo0501.databasemanager.model.PrimaryKey;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface MetaCollectService {

    List<Column> getColumns(String vendor, String url, String id, String password, String tableName) throws Exception;

    List<PrimaryKey> getPrimaryKeys(String vendor, String url, String id, String password, String tableName) throws Exception;

    List<String> getSQLKeywords(String vendor, String url, String id, String password, String tableName) throws Exception;

    ResultSet getStoredProcedures(Connection connection, String catalog, String schemaPattern, String procedureNamePattern);

    List<String> getTableNames(Connection connection);

    Map<String, String> getTablesAndViews(Connection connection);

    List<String> getTableTypes(Connection connection);

    List<String> getViewNames(Connection connection);

}
