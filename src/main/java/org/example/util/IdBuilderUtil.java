package org.example.util;

public final class IdBuilderUtil {

    private IdBuilderUtil() {}

    private static Long studentId = 0L;
    private static Long teacherId = 0L;

    public static Long getNewTeacherId() {
        return teacherId++;
    }
    public static Long getNewStudentId() {
        return studentId++;
    }

}
