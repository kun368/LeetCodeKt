package utils.java.fastcode;

import java.util.TreeMap;

/**
 * 计数器
 */
public class Counter {

    public TreeMap<Integer, Integer> map = new TreeMap<>();

    public void addOnce(int x) {
        map.merge(x, 1, Integer::sum);
    }

    public void removeOnce(int x) {
        map.computeIfPresent(x, (key, oldValue) -> {
            int t = oldValue - 1;
            return t <= 0 ? null : t;
        });
    }
}