package io.github.hsseo0501.databasemanager.service;

import io.github.hsseo0501.databasemanager.model.Column;
import io.github.hsseo0501.databasemanager.model.PrimaryKey;
import io.github.hsseo0501.databasemanager.model.Procedure;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface MetaCollectService {

    List<Column> getColumns(String vendor, String url, String id, String password, String tableName) throws Exception;

    List<PrimaryKey> getPrimaryKeys(String vendor, String url, String id, String password, String tableName) throws Exception;

    List<String> getSQLKeywords(String vendor, String url, String id, String password, String tableName) throws Exception;

    List<Procedure> getStoredProcedures(String vendor, String url, String id, String password
            , String catalog, String schemaPattern, String procedureNamePattern) throws Exception;

    Map<String, String> getTablesAndViews(String vendor, String url, String id, String password
            , Boolean isTable, Boolean isView) throws Exception;

    List<String> getTableTypes(String vendor, String url, String id, String password) throws Exception;

    ResultSet getBestRowIdentifier(String vendor, String url, String id, String password, String catalog, String schema, String table, String scope, String nullable) throws Exception;

    List<String> getCatalogs(String vendor, String url, String id, String password) throws Exception;

    ResultSet getColumnPrivileges(String vendor, String url, String id, String password, String catalog, String schema, String table, String columnNamePattern) throws Exception;

    ResultSet getForeignKeys(String vendor, String url, String id, String password, String catalog, String schema, String table);

    String getRowSetMetaData(String vendor, String url, String id, String password, String sqlQuery) throws Exception;

    List<String> getSchemas(String vendor, String url, String id, String password) throws Exception;

    ResultSet getStoredProcedureColumns(String vendor, String url, String id, String password, String catalog, String schemaPattern, String procedureNamePattern) throws Exception;

    ResultSet getTablePrivileges(String vendor, String url, String id, String password, String catalog, String schemaPattern, String tableNamePattern);

    ResultSet getTypes(String vendor, String url, String id, String password) throws Exception;

}
