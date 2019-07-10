package io.github.hsseo0501.databasemanager.model;

import lombok.Data;

@Data
public class PrimaryKey {

    String catalog;

    String schema;

    String tableName;

    String columnName;

    Short keySequence;

    String keyName;

}
