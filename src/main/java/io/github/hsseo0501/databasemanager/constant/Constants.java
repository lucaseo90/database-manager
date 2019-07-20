package io.github.hsseo0501.databasemanager.constant;

public class Constants {
    public static class Database {
        public static final String DB_VENDOR_POSTGRESQL = "postgresql";
        public static final String JDBC_DRIVER_POSTGRESQL = "org.postgresql.Driver";

        public static final String META_TABLE = "TABLE_CAT";
        public static final String META_TABLE_SCHEMA = "TABLE_SCHEM";
        public static final String META_TABLE_NAME = "TABLE_NAME";
        public static final String META_TABLE_TYPE = "TABLE_TYPE";

        public static final String META_COLUMN_NAME = "COLUMN_NAME";
        public static final String META_COLUMN_TYPE = "COLUMN_TYPE";
        public static final String META_COLUMN_DATA_TYPE = "DATA_TYPE";
        public static final String META_COLUMN_TYPE_NAME = "TYPE_NAME";
        public static final String META_COLUMN_SIZE = "COLUMN_SIZE";
        public static final String META_COLUMN_NULLABLE = "NULLABLE";
        public static final String META_COLUMN_IS_NULLABLE = "IS_NULLABLE";
        public static final String META_COLUMN_ORDINAL_POSITION = "ORDINAL_POSITION";
        public static final String META_COLUMN_DECIMAL_DIGITS = "DECIMAL_DIGITS";
        public static final String META_COLUMN_PSEUDO_COLUMN = "PSEUDO_COLUMN";

        public static final String META_COLUMN_GRANTOR = "GRANTOR";
        public static final String META_COLUMN_GRANTEE = "GRANTEE";
        public static final String META_COLUMN_PRIVILEGE = "PRIVILEGE";
        public static final String META_COLUMN_IS_GRANTABLE = "IS_GRANTABLE";

        public static final String META_KEY_SEQUENCE = "KEY_SEQ";
        public static final String META_KEY_UPDATE_RULE = "UPDATE_RULE";
        public static final String META_KEY_DELETE_RULE = "DELETE_RULE";
        public static final String META_KEY_DEFERRABILITY = "DEFERRABILITY";

        public static final String META_PK_CATALOG = "PKTABLE_CAT";
        public static final String META_PK_SCHEMA = "PKTABLE_SCHEM";
        public static final String META_PK_TABLE_NAME = "PKTABLE_NAME";
        public static final String META_PK_COLUMN_NAME = "PKCOLUMN_NAME";
        public static final String META_FK_CATALOG = "FKTABLE_CAT";
        public static final String META_FK_SCHEMA = "FKTABLE_SCHEM";
        public static final String META_FK_TABLE_NAME = "FKTABLE_NAME";
        public static final String META_FK_COLUMN_NAME = "FKCOLUMN_NAME";
        public static final String META_PK_NAME = "PK_NAME";
        public static final String META_FK_NAME = "FK_NAME";

        public static final String META_PROCEDURE_NAME = "PROCEDURE_NAME";
        public static final String META_PROCEDURE_TYPE = "PROCEDURE_TYPE";
        public static final String META_PROCEDURE_CATALOG = "PROCEDURE_CAT";
        public static final String META_PROCEDURE_SCHEMA = "PROCEDURE_SCHEM";

        public static final String[] META_TABLE_TYPES = {"TABLE"};
        public static final String[] META_VIEW_TYPES = {"VIEW"};
        public static final String[] META_TABLE_AND_VIEW_TYPES = {"TABLE", "VIEW"};

        public static final String STORED_PROCEDURE_RETURNS_RESULT = "procedureReturnsResult";
        public static final String STORED_PROCEDURE_NO_RESULT = "procedureNoResult";
        public static final String STORED_PROCEDURE_RESULT_UNKNOWN = "procedureResultUnknown";
    }
}
