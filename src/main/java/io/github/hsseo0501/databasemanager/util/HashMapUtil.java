package io.github.hsseo0501.databasemanager.util;

public class HashMapUtil {

    public static final float LOAD_FACTOR = 0.75f;

    public static int getCapacity(int size) {
        return (int) (size / LOAD_FACTOR) + 1;
    }
}