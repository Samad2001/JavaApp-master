package org.example.util;

public final class IdBuilderUtil {

    private IdBuilderUtil() {}

    private static Long id = 0L;

    public static Long getNewId() {
        return id++;
    }

}
