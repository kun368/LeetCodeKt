package normal.cat2.cat21.p2121;

import java.util.*;

class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] ret = new long[n];
        Arrays.fill(ret, 0);

        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            idxMap.putIfAbsent(arr[i], new ArrayList<>());
            idxMap.get(arr[i]).add(i);
        }
        for (List<Integer> l : idxMap.values()) {
            if (l.size() <= 1) continue;
            long cnt = 0;
            long sum = 0;
            int pre = l.get(0);
            for (Integer i : l) {
                sum = (i - pre) * cnt + sum;
                cnt += 1;
                pre = i;
                ret[i] += sum;
            }

            Collections.reverse(l);
            cnt = 0;
            sum = 0;
            pre = l.get(0);
            for (Integer i : l) {
                sum = (pre - i) * cnt + sum;
                cnt += 1;
                pre = i;
                ret[i] += sum;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{10, 5, 10, 10})));
    }
}
