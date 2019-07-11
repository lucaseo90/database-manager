package io.github.hsseo0501.databasemanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hsseo0501.databasemanager.constant.Constants;
import io.github.hsseo0501.databasemanager.model.Column;
import io.github.hsseo0501.databasemanager.model.PrimaryKey;
import io.github.hsseo0501.databasemanager.model.Procedure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetaCollectServiceTest {

    private String testDatabaseColumnMeta = "[{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"id\",\"dataType\":\"4\",\"typeName\":\"serial\",\"columnSize\":\"10\",\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"1\"},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"code\",\"dataType\":\"12\",\"typeName\":\"varchar\",\"columnSize\":\"10\",\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"2\"},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"article\",\"dataType\":\"12\",\"typeName\":\"text\",\"columnSize\":\"2147483647\",\"nullable\":\"true\",\"isNullable\":\"YES\",\"ordinalPosition\":\"3\"},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"name\",\"dataType\":\"12\",\"typeName\":\"text\",\"columnSize\":\"2147483647\",\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"4\"}]";
    private String testDatabasePrimaryKeyMeta = "[{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"id\",\"keySequence\":1,\"keyName\":\"test_pkey\"}]";
    private String testDatabaseSQLKeywordMeta = "[\"abort\",\"access\",\"aggregate\",\"also\",\"analyse\",\"analyze\",\"attach\",\"backward\",\"bit\",\"cache\",\"checkpoint\",\"class\",\"cluster\",\"columns\",\"comment\",\"comments\",\"concurrently\",\"configuration\",\"conflict\",\"connection\",\"content\",\"conversion\",\"copy\",\"cost\",\"csv\",\"current_catalog\",\"current_schema\",\"database\",\"delimiter\",\"delimiters\",\"depends\",\"detach\",\"dictionary\",\"disable\",\"discard\",\"do\",\"document\",\"enable\",\"encoding\",\"encrypted\",\"enum\",\"event\",\"exclusive\",\"explain\",\"extension\",\"family\",\"force\",\"forward\",\"freeze\",\"functions\",\"generated\",\"greatest\",\"groups\",\"handler\",\"header\",\"if\",\"ilike\",\"immutable\",\"implicit\",\"import\",\"include\",\"index\",\"indexes\",\"inherit\",\"inherits\",\"inline\",\"instead\",\"isnull\",\"label\",\"leakproof\",\"least\",\"limit\",\"listen\",\"load\",\"location\",\"lock\",\"locked\",\"logged\",\"mapping\",\"materialized\",\"mode\",\"move\",\"nothing\",\"notify\",\"notnull\",\"nowait\",\"off\",\"offset\",\"oids\",\"operator\",\"owned\",\"owner\",\"parallel\",\"parser\",\"passing\",\"password\",\"plans\",\"policy\",\"prepared\",\"procedural\",\"procedures\",\"program\",\"publication\",\"quote\",\"reassign\",\"recheck\",\"refresh\",\"reindex\",\"rename\",\"replace\",\"replica\",\"reset\",\"restrict\",\"returning\",\"routines\",\"rule\",\"schemas\",\"sequences\",\"server\",\"setof\",\"share\",\"show\",\"skip\",\"snapshot\",\"stable\",\"standalone\",\"statistics\",\"stdin\",\"stdout\",\"storage\",\"strict\",\"strip\",\"subscription\",\"sysid\",\"tables\",\"tablespace\",\"temp\",\"template\",\"text\",\"truncate\",\"trusted\",\"types\",\"unencrypted\",\"unlisten\",\"unlogged\",\"until\",\"vacuum\",\"valid\",\"validate\",\"validator\",\"variadic\",\"verbose\",\"version\",\"views\",\"volatile\",\"whitespace\",\"wrapper\",\"xml\",\"xmlattributes\",\"xmlconcat\",\"xmlelement\",\"xmlexists\",\"xmlforest\",\"xmlnamespaces\",\"xmlparse\",\"xmlpi\",\"xmlroot\",\"xmlserialize\",\"xmltable\",\"yes\"]";
    private String testDatabaseTableMeta = "{\"test\":\"TABLE\"}";
    private String testDatabaseTableAndViewMeta = "{\"test\":\"TABLE\",\"test_view\":\"VIEW\"}";
    private String testDatabaseTableTypeMeta = "[\"FOREIGN TABLE\",\"INDEX\",\"MATERIALIZED VIEW\",\"SEQUENCE\",\"SYSTEM INDEX\",\"SYSTEM TABLE\",\"SYSTEM TOAST INDEX\",\"SYSTEM TOAST TABLE\",\"SYSTEM VIEW\",\"TABLE\",\"TEMPORARY INDEX\",\"TEMPORARY SEQUENCE\",\"TEMPORARY TABLE\",\"TEMPORARY VIEW\",\"TYPE\",\"VIEW\"]";
    private String testDatabaseViewMeta = "{\"test_view\":\"VIEW\"}";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MetaCollectService metaCollectService;

    private static final String vendor = Constants.Database.DB_VENDOR_POSTGRESQL;
    private static final String id = "test";
    private static final String password = "pwd";
    private static final String url = "jdbc:postgresql://localhost:15432/test_db";
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
}
