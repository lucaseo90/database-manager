package io.github.hsseo0501.databasemanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hsseo0501.databasemanager.constant.Constants;
import io.github.hsseo0501.databasemanager.model.Column;
import io.github.hsseo0501.databasemanager.model.PrimaryKey;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetaCollectServiceTest {

    private String testDatabaseColumnMeta = "[{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"id\",\"dataType\":\"4\",\"typeName\":\"serial\",\"columnSize\":\"10\",\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"1\"},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"code\",\"dataType\":\"12\",\"typeName\":\"varchar\",\"columnSize\":\"10\",\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"2\"},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"article\",\"dataType\":\"12\",\"typeName\":\"text\",\"columnSize\":\"2147483647\",\"nullable\":\"true\",\"isNullable\":\"YES\",\"ordinalPosition\":\"3\"},{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"name\",\"dataType\":\"12\",\"typeName\":\"text\",\"columnSize\":\"2147483647\",\"nullable\":\"false\",\"isNullable\":\"NO\",\"ordinalPosition\":\"4\"}]";
    private String testDatabasePrimaryKeyMeta = "[{\"catalog\":null,\"schema\":\"public\",\"tableName\":\"test\",\"columnName\":\"id\",\"keySequence\":1,\"keyName\":\"test_pkey\"}]";
    private String testDatabaseSQLKeywordMeta = "[\"abort\",\"access\",\"aggregate\",\"also\",\"analyse\",\"analyze\",\"attach\",\"backward\",\"bit\",\"cache\",\"checkpoint\",\"class\",\"cluster\",\"columns\",\"comment\",\"comments\",\"concurrently\",\"configuration\",\"conflict\",\"connection\",\"content\",\"conversion\",\"copy\",\"cost\",\"csv\",\"current_catalog\",\"current_schema\",\"database\",\"delimiter\",\"delimiters\",\"depends\",\"detach\",\"dictionary\",\"disable\",\"discard\",\"do\",\"document\",\"enable\",\"encoding\",\"encrypted\",\"enum\",\"event\",\"exclusive\",\"explain\",\"extension\",\"family\",\"force\",\"forward\",\"freeze\",\"functions\",\"generated\",\"greatest\",\"groups\",\"handler\",\"header\",\"if\",\"ilike\",\"immutable\",\"implicit\",\"import\",\"include\",\"index\",\"indexes\",\"inherit\",\"inherits\",\"inline\",\"instead\",\"isnull\",\"label\",\"leakproof\",\"least\",\"limit\",\"listen\",\"load\",\"location\",\"lock\",\"locked\",\"logged\",\"mapping\",\"materialized\",\"mode\",\"move\",\"nothing\",\"notify\",\"notnull\",\"nowait\",\"off\",\"offset\",\"oids\",\"operator\",\"owned\",\"owner\",\"parallel\",\"parser\",\"passing\",\"password\",\"plans\",\"policy\",\"prepared\",\"procedural\",\"procedures\",\"program\",\"publication\",\"quote\",\"reassign\",\"recheck\",\"refresh\",\"reindex\",\"rename\",\"replace\",\"replica\",\"reset\",\"restrict\",\"returning\",\"routines\",\"rule\",\"schemas\",\"sequences\",\"server\",\"setof\",\"share\",\"show\",\"skip\",\"snapshot\",\"stable\",\"standalone\",\"statistics\",\"stdin\",\"stdout\",\"storage\",\"strict\",\"strip\",\"subscription\",\"sysid\",\"tables\",\"tablespace\",\"temp\",\"template\",\"text\",\"truncate\",\"trusted\",\"types\",\"unencrypted\",\"unlisten\",\"unlogged\",\"until\",\"vacuum\",\"valid\",\"validate\",\"validator\",\"variadic\",\"verbose\",\"version\",\"views\",\"volatile\",\"whitespace\",\"wrapper\",\"xml\",\"xmlattributes\",\"xmlconcat\",\"xmlelement\",\"xmlexists\",\"xmlforest\",\"xmlnamespaces\",\"xmlparse\",\"xmlpi\",\"xmlroot\",\"xmlserialize\",\"xmltable\",\"yes\"]";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MetaCollectService metaCollectService;

    @Test
    public void getColumnsTest() throws Exception{
        String vendor = Constants.Database.DB_VENDOR_POSTGRESQL;
        String id = "test";
        String password = "pwd";
        String url = "jdbc:postgresql://localhost:15432/test_db";
        String tableName = "test";

        List<Column> columnList = metaCollectService.getColumns(vendor, url, id, password, tableName);
        Assert.assertEquals(testDatabaseColumnMeta, objectMapper.writeValueAsString(columnList));
    }

    @Test
    public void getPrimaryKeyTest() throws Exception{
        String vendor = Constants.Database.DB_VENDOR_POSTGRESQL;
        String id = "test";
        String password = "pwd";
        String url = "jdbc:postgresql://localhost:15432/test_db";
        String tableName = "test";

        List<PrimaryKey> keyList = metaCollectService.getPrimaryKeys(vendor, url, id, password, tableName);
        Assert.assertEquals(testDatabasePrimaryKeyMeta, objectMapper.writeValueAsString(keyList));
    }

    @Test
    public void getSQLKeywordTest() throws Exception{
        String vendor = Constants.Database.DB_VENDOR_POSTGRESQL;
        String id = "test";
        String password = "pwd";
        String url = "jdbc:postgresql://localhost:15432/test_db";
        String tableName = "test";

        List<String> SQLKeywords = metaCollectService.getSQLKeywords(vendor, url, id, password, tableName);
        Assert.assertEquals(testDatabaseSQLKeywordMeta, objectMapper.writeValueAsString(SQLKeywords));
    }

}
