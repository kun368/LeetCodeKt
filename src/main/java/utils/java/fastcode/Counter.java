package utils.java.fastcode;

import java.util.TreeMap;

/**
 * 计数器
 */
public class Counter<K> extends TreeMap<K, Integer> {

    public void addOnce(K x) {
        this.merge(x, 1, Integer::sum);
    }

    public void removeOnce(K x) {
        this.computeIfPresent(x, (key, oldValue) -> {
            int t = oldValue - 1;
            return t <= 0 ? null : t;
        });
    }
}
