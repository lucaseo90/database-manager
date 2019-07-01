package io.github.hsseo0501.databasemanager.util;

import javax.sql.RowSet;
import java.sql.*;

public class DatabaseUtil {
    public static void close(RowSet var0) {
        try {
            if (var0 != null) {
                var0.close();
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void close(ResultSet var0) {
        try {
            if (var0 != null) {
                var0.close();
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void close(Statement var0) {
        try {
            if (var0 != null) {
                var0.close();
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void close(PreparedStatement var0) {
        try {
            if (var0 != null) {
                var0.close();
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void close(Connection var0) {
        try {
            if (var0 != null) {
                var0.close();
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static Date getJavaSqlDate() {
        java.util.Date var0 = new java.util.Date();
        return new Date(var0.getTime());
    }

    public static String getTrimmedString(ResultSet var0, int var1) throws SQLException {
        String var2 = var0.getString(var1);
        if (var2 != null) {
            var2 = var2.trim();
        }

        return var2;
    }

    public static String getTrimmedString(ResultSet var0, String var1) throws SQLException {
        String var2 = var0.getString(var1);
        if (var2 != null) {
            var2 = var2.trim();
        }

        return var2;
    }
}
