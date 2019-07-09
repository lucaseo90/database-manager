package io.github.hsseo0501.databasemanager.model;

import lombok.Data;

@Data
public class Column {

    String catalog;

    String schema;

    String tableName;

    String columnName;

    String dataType;

    String typeName;

    String columnSize;

    String nullable;

    String isNullable;

    String ordinalPosition;

}
