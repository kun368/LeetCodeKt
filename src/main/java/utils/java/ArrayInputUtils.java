package utils.java;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解析数组输入方便Utils
 */
public class ArrayInputUtils {

    // ========================== 一维数组 ==========================

    public static List<String> parseStrList1(String str) {
        try {
            return JSON.parseArray(str, String.class);
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

    // ========================== 二维数组 ==========================

    public static List<List<String>> parseStrList2(String str) {
        return JSON.parseObject(str, new TypeReference<List<List<String>>>() {
        });
    }

    public static List<List<Integer>> parseIntList2(String str) {
        return JSON.parseObject(str, new TypeReference<List<List<Integer>>>() {
        });
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
            return (T) JSON.parseObject(str, Class.forName(className));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ========================== 测试 ==========================

    public static void main(String[] args) {
        System.out.println(parseStrList1("1, 2"));
        System.out.println(parseStrList1("[1, 2]"));
        System.out.println(parseStrList2("[[1, 2], [3, 4]]"));
        System.out.println(Arrays.deepToString(parseIntArr2("[[1, 2], [3, 4]]")));
    }
}
