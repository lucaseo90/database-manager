package io.github.hsseo0501.databasemanager.model;

import lombok.Data;

@Data
public class ExportedKey {
    String pkTableCatalog;

    String pkTableSchema;

    String pkTableName;

    String pkColumnName;

    String fkTableCatalog;

    String fkTableSchema;

    String fkTableName;

    String fkColumnName;

    String keySequence;

    String updateRule;

    String deleteRule;

    String pkName;

    String fkName;

    String deferrability;
}
