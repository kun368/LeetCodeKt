package match.weekly.weekly194.p3;

import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ret = new int[rains.length];
        Set<Integer> fillSet = new HashSet<>();
        Map<Integer, Integer> preRain = new HashMap<>();
        TreeSet<Integer> pullIdx = new TreeSet<>();

        for (int i = 0; i < rains.length; ++i) {
            int cur = rains[i];
            if (cur > 0) {
                if (!fillSet.contains(cur)) {
                    fillSet.add(cur);
                } else {
                    Integer pull = pullIdx.higher(preRain.get(cur));
                    if (pull == null) {
                        return new int[0];
                    } else {
                        pullIdx.remove(pull);
                        ret[pull] = cur;
                    }
                }
                preRain.put(cur, i);
            } else {
                pullIdx.add(i);
            }
        }
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0 && ret[i] == 0) {
                ret[i] = 1;
            } else if (rains[i] > 0) {
                ret[i] = -1;
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 0, 1, 2})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{69, 0, 0, 0, 69})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{10, 20, 20})));
    }
}
