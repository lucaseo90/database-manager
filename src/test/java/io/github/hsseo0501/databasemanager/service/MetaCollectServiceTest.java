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

}
