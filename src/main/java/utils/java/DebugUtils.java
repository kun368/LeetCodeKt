package utils.java;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ClassUtil;
import com.alibaba.fastjson.JSON;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 调试方便Utils
 *
 * @author kunwu
 * @date 2020/1/20 10:29 上午
 */
public class DebugUtils extends ArrayInputUtils {

    public static void print(Object... objs) {
        for (int i = 0; i < objs.length; ++i) {
            Object obj = objs[i];
            if (obj instanceof CharSequence || ClassUtil.isBasicType(obj.getClass())) {
                System.out.print(obj);
            } else {
                System.out.print(JSON.toJSONString(obj));
            }
            if (i != objs.length - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }

    public static List<String> readIn() {
        try {
            FileInputStream stream = new FileInputStream("in.txt");
            return IoUtil.readLines(stream, "utf8", new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
