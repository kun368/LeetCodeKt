package match.biweekly.biweekly22.p3;

import java.util.*;

class Solution {

    private Map<Integer, Integer> weightMap = new HashMap<>();

    int calcWeight(int x) {
        if (x == 1) {
            return 0;
        }
        if (weightMap.containsKey(x)) {
            return weightMap.get(x);
        }
        int ans;
        if (x % 2 == 0) {
            ans = calcWeight(x / 2) + 1;
        } else {
            ans = calcWeight(3 * x + 1) + 1;
        }
        weightMap.put(x, ans);
        return ans;
    }

    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i <= hi; ++i) {
            list.add(i);
        }
        list.sort(Comparator.comparingInt(this::calcWeight).thenComparingInt(o -> o));
        return list.get(k - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getKth(7, 11, 4));
        System.out.println(new Solution().getKth(10, 20, 5));
        System.out.println(new Solution().getKth(1, 1000, 777));
    }
}
