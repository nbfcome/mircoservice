package com.mzjf.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.lang3.StringUtils;

/**
 * @author niebiaofei
 *
 */
public class GenerateMapperUtils {

    public static <T> void generateEquals(Class<T> clazz) {
        StringBuffer stringBuffer = new StringBuffer();
        String clazzName = clazz.getSimpleName();
        stringBuffer.append("    @Override").append("\n")
                .append("    public boolean equals(Object o) {").append("\n")
                .append("        if (this == o) {return true;}").append("\n")
                .append("        if (o == null || getClass() != o.getClass()) { return false; }")
                .append("\n").append("\n").append("        ")
                .append(clazzName).append(" other = (").append(clazzName).append(") o;")
                .append("\n").append("\n")
                .append("        return ");

        for (Method method : clazz.getDeclaredMethods()) {
            String methodName = method.getName();
            if (methodName.startsWith("get") || methodName.startsWith("is")) {
                stringBuffer.append("Objects.equals(this.").append(methodName).append("(), other.")
                        .append(methodName).append("()) &&");
            }
        }
        stringBuffer.replace(stringBuffer.length() - 2, stringBuffer.length() - 0, ";")
                .append("\n    ").append("}").append("\n");
        System.out.println(stringBuffer.toString());
    }

    /**
     * @Select("select * from comment where id = #{id}")
        public List<Comment> getCommentById(@Param("id") Long id);

        @Insert("insert into comment(name) values (#{comment.name})")
        public long add(@Param("comment") Comment comment);

        @Update("update comment set status = #{comment.status} where id = #{comment.id} ")
        public void update(@Param("comment") Comment comment);
     *
     */
    public static <T> void generateMapper(Class<T> clazz) {
        StringBuffer result = new StringBuffer();
        String clazzName = clazz.getSimpleName();
        String var = StringUtils.lowerCase(clazzName.substring(0, 1))
        + StringUtils.substring(clazzName, 1, clazzName.length());
        Field[] fields = clazz.getDeclaredFields();
        StringBuffer filedsStringBuffer = new StringBuffer();
        StringBuffer fieldsValueStringBuffer = new StringBuffer();
        for (Field field : fields) {
            if (!isStatic(field.getModifiers()) && isStatic(field.getModifiers())) {
                filedsStringBuffer.append(field.getName()).append(", ");
                fieldsValueStringBuffer.append("#{").append(var).append(".").append(field.getName()).append("},");
            }
        }
        String fieldsValueString = StringUtils.removeEnd(fieldsValueStringBuffer.toString(), ", ");
        String fieldsString = StringUtils.removeEnd(filedsStringBuffer.toString(), ", ");
        result.append("    @Select(\"select ").append(fieldsString).append(" from ")
                .append(var)
                .append(" where id = #{id}").append("\n")
                .append("    public List<CommentPraise> scan(@Param(\"id\") Long id);")
                .append("\n").append("\n");
        result.append("    @Insert(\"insert into ").append(var).append("(").append(fieldsString).append(") values (").append(fieldsValueString).append(")\")").append("\n");
    }

    private static boolean isStatic(int modifiers) {
        return ((modifiers & Modifier.STATIC) != 0);
    }

    private static boolean isPrivate(int modifiers) {
        return ((modifiers & Modifier.PRIVATE) != 0);
    }

    public static void main(String args[]) {
    }
}
