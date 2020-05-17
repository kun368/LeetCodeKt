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
        return ArrayUtil.unWrap(Convert.toIntArray(parseStrList1(str)));
    }

    public static long[] parseLongArr1(String str) {
        return ArrayUtil.unWrap(Convert.toLongArray(parseStrList1(str)));
    }

    // ========================== 二维数组 ==========================

    public static List<List<String>> parseStrList2(String str) {
        return JSON.parseObject(str, new TypeReference<List<List<String>>>() {
        });
    }

    public static int[][] parseIntArr2(String str) {
        List<List<String>> lists = parseStrList2(str);
        int[][] ret = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            ret[i] = ArrayUtil.unWrap(Convert.toIntArray(lists.get(i)));
        }
        return ret;
    }

    public static long[][] parseLongArr2(String str) {
        List<List<String>> lists = parseStrList2(str);
        long[][] ret = new long[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            ret[i] = ArrayUtil.unWrap(Convert.toLongArray(lists.get(i)));
        }
        return ret;
    }

    // ========================== 测试 ==========================

    public static void main(String[] args) {
        System.out.println(parseStrList1("1, 2"));
        System.out.println(parseStrList1("[1, 2]"));
        System.out.println(parseStrList2("[[1, 2], [3, 4]]"));
        System.out.println(Arrays.deepToString(parseIntArr2("[[1, 2], [3, 4]]")));
    }
}
