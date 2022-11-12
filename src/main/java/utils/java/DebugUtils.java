package utils.java;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ClassUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

/**
 * 解析数组输入方便 Utils
 */
public class DebugUtils {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // ======================================================================

    public static List<String> parseStrList1(String str) {
        try {
            return objectMapper.readValue(str, new TypeReference<List<String>>() {
            });
        } catch (Exception e) {
            return Convert.toList(String.class, str);
        }
    }

    public static String[] parseStrArr1(String str) {
        return Convert.toStrArray(parseStrList1(str));
    }

    public static int[] parseIntArr1(String str) {
        return json2Array(str, "[I");
    }

    public static char[] parseCharArr1(String str) {
        return json2Array(str, "[C");
    }

    public static long[] parseLongArr1(String str) {
        return json2Array(str, "[L");
    }

    public static List<List<String>> parseStrList2(String str) {
        try {
            return objectMapper.readValue(str, new TypeReference<List<List<String>>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Integer>> parseIntList2(String str) {
        try {
            return objectMapper.readValue(str, new TypeReference<List<List<Integer>>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] parseIntArr2(String str) {
        return json2Array(str, "[[I");
    }

    public static char[][] parseCharArr2(String str) {
        return json2Array(str, "[[C");
    }

    public static long[][] parseLongArr2(String str) {
        return json2Array(str, "[[L");
    }

    @SuppressWarnings("unchecked")
    private static <T> T json2Array(String str, String className) {
        try {
            return (T) objectMapper.readValue(str, Class.forName(className));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ======================================================================

    @SneakyThrows
    public static void print(Object... objs) {
        for (int i = 0; i < objs.length; ++i) {
            Object obj = objs[i];
            if (obj instanceof CharSequence || ClassUtil.isBasicType(obj.getClass())) {
                System.out.print(obj);
            } else {
                System.out.print(toJsonString(obj));
            }
            if (i != objs.length - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }

    // ======================================================================

    public static void main(String[] args) {
        System.out.println(parseStrList1("1, 2"));
        System.out.println(parseStrList1("[1, 2]"));
        System.out.println(parseStrList2("[[1, 2], [3, 4]]"));
        System.out.println(Arrays.deepToString(parseIntArr2("[[1, 2], [3, 4]]")));
    }
}
