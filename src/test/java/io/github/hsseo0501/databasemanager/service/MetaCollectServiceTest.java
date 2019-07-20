package io.github.hsseo0501.databasemanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hsseo0501.databasemanager.constant.Constants;
import io.github.hsseo0501.databasemanager.model.Column;
import io.github.hsseo0501.databasemanager.model.ExportedKey;
import io.github.hsseo0501.databasemanager.model.PrimaryKey;
import io.github.hsseo0501.databasemanager.model.Procedure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetaCollectServiceTest {

    private String testDatabaseColumnMeta = "[{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"id\",\"dataType\":\"4\",\"typeName\":\"serial\",\"columnSize\":10,\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"1\",\"decimalDigits\":null,\"pseudoColumn\":null,\"grantor\":null,\"grantee\":null,\"privilege\":null,\"isGrantable\":null},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"code\",\"dataType\":\"12\",\"typeName\":\"varchar\",\"columnSize\":10,\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"2\",\"decimalDigits\":null,\"pseudoColumn\":null,\"grantor\":null,\"grantee\":null,\"privilege\":null,\"isGrantable\":null},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"article\",\"dataType\":\"12\",\"typeName\":\"text\",\"columnSize\":2147483647,\"nullable\":\"true\",\"isNullable\":\"YES\",\"ordinalPosition\":\"3\",\"decimalDigits\":null,\"pseudoColumn\":null,\"grantor\":null,\"grantee\":null,\"privilege\":null,\"isGrantable\":null},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"name\",\"dataType\":\"12\",\"typeName\":\"text\",\"columnSize\":2147483647,\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"4\",\"decimalDigits\":null,\"pseudoColumn\":null,\"grantor\":null,\"grantee\":null,\"privilege\":null,\"isGrantable\":null}]";
    private String testDatabasePrimaryKeyMeta = "[{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"id\",\"keySequence\":1,\"keyName\":\"1\"}]";
    private String testDatabaseSQLKeywordMeta = "[\"abort\",\"access\",\"aggregate\",\"also\",\"analyse\",\"analyze\",\"attach\",\"backward\",\"bit\",\"cache\",\"checkpoint\",\"class\",\"cluster\",\"columns\",\"comment\",\"comments\",\"concurrently\",\"configuration\",\"conflict\",\"connection\",\"content\",\"conversion\",\"copy\",\"cost\",\"csv\",\"current_catalog\",\"current_schema\",\"database\",\"delimiter\",\"delimiters\",\"depends\",\"detach\",\"dictionary\",\"disable\",\"discard\",\"do\",\"document\",\"enable\",\"encoding\",\"encrypted\",\"enum\",\"event\",\"exclusive\",\"explain\",\"extension\",\"family\",\"force\",\"forward\",\"freeze\",\"functions\",\"generated\",\"greatest\",\"groups\",\"handler\",\"header\",\"if\",\"ilike\",\"immutable\",\"implicit\",\"import\",\"include\",\"index\",\"indexes\",\"inherit\",\"inherits\",\"inline\",\"instead\",\"isnull\",\"label\",\"leakproof\",\"least\",\"limit\",\"listen\",\"load\",\"location\",\"lock\",\"locked\",\"logged\",\"mapping\",\"materialized\",\"mode\",\"move\",\"nothing\",\"notify\",\"notnull\",\"nowait\",\"off\",\"offset\",\"oids\",\"operator\",\"owned\",\"owner\",\"parallel\",\"parser\",\"passing\",\"password\",\"plans\",\"policy\",\"prepared\",\"procedural\",\"procedures\",\"program\",\"publication\",\"quote\",\"reassign\",\"recheck\",\"refresh\",\"reindex\",\"rename\",\"replace\",\"replica\",\"reset\",\"restrict\",\"returning\",\"routines\",\"rule\",\"schemas\",\"sequences\",\"server\",\"setof\",\"share\",\"show\",\"skip\",\"snapshot\",\"stable\",\"standalone\",\"statistics\",\"stdin\",\"stdout\",\"storage\",\"strict\",\"strip\",\"subscription\",\"sysid\",\"tables\",\"tablespace\",\"temp\",\"template\",\"text\",\"truncate\",\"trusted\",\"types\",\"unencrypted\",\"unlisten\",\"unlogged\",\"until\",\"vacuum\",\"valid\",\"validate\",\"validator\",\"variadic\",\"verbose\",\"version\",\"views\",\"volatile\",\"whitespace\",\"wrapper\",\"xml\",\"xmlattributes\",\"xmlconcat\",\"xmlelement\",\"xmlexists\",\"xmlforest\",\"xmlnamespaces\",\"xmlparse\",\"xmlpi\",\"xmlroot\",\"xmlserialize\",\"xmltable\",\"yes\"]";
    private String testDatabaseTableMeta = "{\"film_category\":\"TABLE\",\"country\":\"TABLE\",\"address\":\"TABLE\",\"test\":\"TABLE\",\"city\":\"TABLE\",\"film_actor\":\"TABLE\",\"language\":\"TABLE\",\"staff\":\"TABLE\",\"film\":\"TABLE\",\"store\":\"TABLE\",\"inventory\":\"TABLE\",\"rental\":\"TABLE\",\"actor\":\"TABLE\",\"payment\":\"TABLE\",\"category\":\"TABLE\",\"customer\":\"TABLE\"}";
    private String testDatabaseTableAndViewMeta = "{\"film_category\":\"TABLE\",\"country\":\"TABLE\",\"address\":\"TABLE\",\"actor_info\":\"VIEW\",\"test\":\"TABLE\",\"city\":\"TABLE\",\"film_actor\":\"TABLE\",\"customer_list\":\"VIEW\",\"sales_by_film_category\":\"VIEW\",\"language\":\"TABLE\",\"staff\":\"TABLE\",\"film\":\"TABLE\",\"store\":\"TABLE\",\"inventory\":\"TABLE\",\"sales_by_store\":\"VIEW\",\"rental\":\"TABLE\",\"actor\":\"TABLE\",\"staff_list\":\"VIEW\",\"film_list\":\"VIEW\",\"payment\":\"TABLE\",\"nicer_but_slower_film_list\":\"VIEW\",\"test_view\":\"VIEW\",\"category\":\"TABLE\",\"customer\":\"TABLE\"}";
    private String testDatabaseTableTypeMeta = "[\"FOREIGN TABLE\",\"INDEX\",\"MATERIALIZED VIEW\",\"SEQUENCE\",\"SYSTEM INDEX\",\"SYSTEM TABLE\",\"SYSTEM TOAST INDEX\",\"SYSTEM TOAST TABLE\",\"SYSTEM VIEW\",\"TABLE\",\"TEMPORARY INDEX\",\"TEMPORARY SEQUENCE\",\"TEMPORARY TABLE\",\"TEMPORARY VIEW\",\"TYPE\",\"VIEW\"]";
    private String testDatabaseViewMeta = "{\"actor_info\":\"VIEW\",\"staff_list\":\"VIEW\",\"film_list\":\"VIEW\",\"customer_list\":\"VIEW\",\"sales_by_film_category\":\"VIEW\",\"nicer_but_slower_film_list\":\"VIEW\",\"test_view\":\"VIEW\",\"sales_by_store\":\"VIEW\"}";
    private String testDatabaseBestRowIdentifierTest = "[]";
    private String catalogTestResult = "[\"postgres\"]";
    private String exportedKeyTestResult = "[{\"pkTableCatalog\":null,\"pkTableSchema\":\"public\",\"pkTableName\":\"address\",\"pkColumnName\":\"address_id\",\"fkTableCatalog\":null,\"fkTableSchema\":\"public\",\"fkTableName\":\"customer\",\"fkColumnName\":\"address_id\",\"keySequence\":\"1\",\"updateRule\":\"importedKeyCascade\",\"deleteRule\":\"importedKeyRestrict\",\"pkName\":\"address_pkey\",\"fkName\":\"customer_address_id_fkey\",\"deferrability\":\"importedKeyNotDeferrable\"},{\"pkTableCatalog\":null,\"pkTableSchema\":\"public\",\"pkTableName\":\"address\",\"pkColumnName\":\"address_id\",\"fkTableCatalog\":null,\"fkTableSchema\":\"public\",\"fkTableName\":\"staff\",\"fkColumnName\":\"address_id\",\"keySequence\":\"1\",\"updateRule\":\"importedKeyCascade\",\"deleteRule\":\"importedKeyRestrict\",\"pkName\":\"address_pkey\",\"fkName\":\"staff_address_id_fkey\",\"deferrability\":\"importedKeyNotDeferrable\"},{\"pkTableCatalog\":null,\"pkTableSchema\":\"public\",\"pkTableName\":\"address\",\"pkColumnName\":\"address_id\",\"fkTableCatalog\":null,\"fkTableSchema\":\"public\",\"fkTableName\":\"store\",\"fkColumnName\":\"address_id\",\"keySequence\":\"1\",\"updateRule\":\"importedKeyCascade\",\"deleteRule\":\"importedKeyRestrict\",\"pkName\":\"address_pkey\",\"fkName\":\"store_address_id_fkey\",\"deferrability\":\"importedKeyNotDeferrable\"}]";
    private String foreignKeyTestResult = "[{\"pkTableCatalog\":null,\"pkTableSchema\":\"public\",\"pkTableName\":\"city\",\"pkColumnName\":\"city_id\",\"fkTableCatalog\":null,\"fkTableSchema\":\"public\",\"fkTableName\":\"address\",\"fkColumnName\":\"city_id\",\"keySequence\":\"1\",\"updateRule\":\"importedKeyNoAction\",\"deleteRule\":\"importedKeyNoAction\",\"pkName\":\"city_pkey\",\"fkName\":\"fk_address_city\",\"deferrability\":\"importedKeyNotDeferrable\"}]";
    private String schemaTestResult = "[\"information_schema\",\"pg_catalog\",\"public\"]";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MetaCollectService metaCollectService;

    private static final String vendor = Constants.Database.DB_VENDOR_POSTGRESQL;
    private static final String id = "test";
    private static final String password = "pwd";
    private static final String url = "jdbc:postgresql://localhost:15432/postgres";
    private static final String tableName = "test";

    @Test
    public void getColumnsTest() throws Exception {
        List<Column> columnList = metaCollectService.getColumns(vendor, url, id, password, tableName);
        Assert.assertEquals(testDatabaseColumnMeta, objectMapper.writeValueAsString(columnList));
    }

    @Test
    public void getPrimaryKeyTest() throws Exception {
        List<PrimaryKey> keyList = metaCollectService.getPrimaryKeys(vendor, url, id, password, tableName);
        Assert.assertEquals(testDatabasePrimaryKeyMeta, objectMapper.writeValueAsString(keyList));
    }

    @Test
    public void getSQLKeywordTest() throws Exception {
        List<String> SQLKeywords = metaCollectService.getSQLKeywords(vendor, url, id, password, tableName);
        Assert.assertEquals(testDatabaseSQLKeywordMeta, objectMapper.writeValueAsString(SQLKeywords));
    }

    @Test
    public void getStoredProceduresTest() throws Exception {
        String catalog = "catalog";
        String schemaPattern = "%";
        String procedureNamePattern = "%";

        List<Procedure> ProcedureList = metaCollectService.getStoredProcedures(vendor, url, id, password, catalog, schemaPattern, procedureNamePattern);
        Assert.assertNotNull(ProcedureList);
    }

    @Test
    public void getTableNamesTest() throws Exception {
        Map<String, String> tableMap = metaCollectService.getTablesAndViews(vendor, url, id, password, true, false);
        Assert.assertEquals(testDatabaseTableMeta, objectMapper.writeValueAsString(tableMap));
    }

    @Test
    public void getTablesAndViewsTest() throws Exception {
        Map<String, String> tableMap = metaCollectService.getTablesAndViews(vendor, url, id, password, true, true);
        Assert.assertEquals(testDatabaseTableAndViewMeta, objectMapper.writeValueAsString(tableMap));
    }

    @Test
    public void getTableTypesTest() throws Exception {
        List<String> tableTypeList = metaCollectService.getTableTypes(vendor, url, id, password);
        Assert.assertEquals(testDatabaseTableTypeMeta, objectMapper.writeValueAsString(tableTypeList));
    }

    @Test
    public void getViewNamesTest() throws Exception {
        Map<String, String> tableMap = metaCollectService.getTablesAndViews(vendor, url, id, password, false, true);
        Assert.assertEquals(testDatabaseViewMeta, objectMapper.writeValueAsString(tableMap));
    }

    @Test
    public void getBestRowIdentifierTest() throws Exception {
        Connection connection = DriverManager.getConnection(url, id, password);
        List<Column> columnList = metaCollectService.getBestRowIdentifier(vendor, url, id, password, connection.getCatalog(), "", "test", DatabaseMetaData.bestRowTemporary, false);
        Assert.assertEquals(testDatabaseBestRowIdentifierTest, objectMapper.writeValueAsString(columnList));
    }

    @Test
    public void getCatalogsTest() throws Exception {
        List<String> catalogList = metaCollectService.getCatalogs(vendor, url, id, password);
        Assert.assertEquals(catalogTestResult, objectMapper.writeValueAsString(catalogList));
    }

    @Test
    public void getColumnPrivilegesTest() throws Exception {
        Connection connection = DriverManager.getConnection(url, id, password);
        List<Column> columnList = metaCollectService.getColumnPrivileges(vendor, url, id, password, connection.getCatalog(), null, "test", "%");
        Assert.assertNotNull(objectMapper.writeValueAsString(columnList));
    }

    @Test
    public void getExportedKeysTest() throws Exception {
        Connection connection = DriverManager.getConnection(url, id, password);
        List<ExportedKey> exportedKeyList = metaCollectService.getExportedKeys(vendor, url, id, password, connection.getCatalog(), null, "address");
        Assert.assertEquals(exportedKeyTestResult, objectMapper.writeValueAsString(exportedKeyList));
    }

    @Test
    public void getForeignKeysTest() throws Exception {
        Connection connection = DriverManager.getConnection(url, id, password);
        List<ExportedKey> foreignKeyList = metaCollectService.getForeignKeys(vendor, url, id, password, connection.getCatalog(), null, "address");
        Assert.assertEquals(foreignKeyTestResult, objectMapper.writeValueAsString(foreignKeyList));
    }

    @Test
    public void getSchemasTest() throws Exception {
        List<String> schemaList = metaCollectService.getSchemas(vendor, url, id, password);
        Assert.assertEquals(schemaTestResult, objectMapper.writeValueAsString(schemaList));
    }

    @Test
    public void getStoredProcedureColumnsTest() throws Exception {
        Connection connection = DriverManager.getConnection(url, id, password);
        String schemaPattern = "%";
        String procedureNamePattern = "%";

        List<Procedure> StoredProcedureColumnList = metaCollectService.getStoredProcedureColumns(vendor, url, id, password, connection.getCatalog(), schemaPattern, procedureNamePattern);
        Assert.assertNotNull(StoredProcedureColumnList);
    }

    @Test
    public void getTablePrivilegesTest() throws Exception {
        String schemaPattern = "%";
        String tableNamePattern = "%";
        Connection connection = DriverManager.getConnection(url, id, password);
        List<Column> tableList = metaCollectService.getTablePrivileges(vendor, url, id, password, connection.getCatalog(), schemaPattern, tableNamePattern);
        Assert.assertNotNull(tableList);
    }

    @Test
    public void getTypesTest() throws Exception {
        List<Column> typeList = metaCollectService.getTypes(vendor, url, id, password);
        Assert.assertNotNull(typeList);
    }

}
