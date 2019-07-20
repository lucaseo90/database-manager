package io.github.hsseo0501.databasemanager.model;

import lombok.Data;

@Data
public class Procedure {

    String procedureName;

    String procedureType;

    String procedureCatalog;

    String procedureSchema;

    String procedureColumnName;

    String procedureColumnType;

    String procedureTypeName;

    String procedureNullable;

}
