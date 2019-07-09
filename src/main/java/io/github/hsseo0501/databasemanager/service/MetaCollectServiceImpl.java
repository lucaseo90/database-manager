package io.github.hsseo0501.databasemanager.service;

import io.github.hsseo0501.databasemanager.constant.Constants;
import io.github.hsseo0501.databasemanager.model.Column;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class MetaCollectServiceImpl implements MetaCollectService {

    @Override
    public List<Column> getColumns(String vendor, String url, String id, String password, String tableName) throws Exception {
        List<Column> columnList = new LinkedList<>();
        if (vendor.equalsIgnoreCase(Constants.Database.DB_VENDOR_POSTGRESQL)) {
            Class.forName(Constants.Database.JDBC_DRIVER_POSTGRESQL);
            Connection connection = DriverManager.getConnection(url, id, password);
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet columns = databaseMetaData.getColumns(null, null, tableName, null);

            while (columns.next()) {
                Column column = new Column();
                column.setCatalog(columns.getString(Constants.Database.COLUMN_META_TABLE));
                column.setSchema(columns.getString(Constants.Database.COLUMN_META_TABLE_SCHEMA));
                column.setTableName(columns.getString(Constants.Database.COLUMN_META_TABLE_NAME));
                column.setColumnName(columns.getString(Constants.Database.COLUMN_META_NAME));
                column.setDataType(columns.getString(Constants.Database.COLUMN_META_DATA_TYPE));
                column.setTypeName(columns.getString(Constants.Database.COLUMN_META_TYPE_NAME));
                column.setColumnSize(columns.getString(Constants.Database.COLUMN_META_SIZE));
                int nullable = columns.getInt(Constants.Database.COLUMN_META_NULLABLE);
                if (nullable == DatabaseMetaData.columnNullable) {
                    column.setNullable("true");
                } else if (nullable == DatabaseMetaData.columnNoNulls) {
                    column.setNullable("false");
                } else {
                    column.setNullable("unknown");
                }
                column.setIsNullable(columns.getString(Constants.Database.COLUMN_META_IS_NULLABLE));
                column.setOrdinalPosition(columns.getString(Constants.Database.COLUMN_META_ORDINAL_POSITION));
                columnList.add(column);
            }
        } else {
            throw new Exception("unknown db vendor");
        }
        return columnList;
    }

    @Override
    public ResultSet getPrimaryKeys(Connection connection, String tableName) {
        return null;
    }

    @Override
    public List<String> getSQLKeywords(Connection connection) {
        return null;
    }

    @Override
    public ResultSet getStoredProcedures(Connection connection, String catalog, String schemaPattern, String procedureNamePattern) {
        return null;
    }

    @Override
    public List<String> getTableNames(Connection connection) {
        return null;
    }

    @Override
    public Map<String, String> getTablesAndViews(Connection connection) {
        return null;
    }

    @Override
    public List<String> getTableTypes(Connection connection) {
        return null;
    }

    @Override
    public List<String> getViewNames(Connection connection) {
        return null;
    }
}
