package io.github.hsseo0501.databasemanager.service;

import io.github.hsseo0501.databasemanager.model.Column;
import io.github.hsseo0501.databasemanager.model.PrimaryKey;
import io.github.hsseo0501.databasemanager.model.Procedure;

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

}
