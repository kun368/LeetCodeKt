package normal.cat0.cat03.cat031.p315;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class Solution {

    private void add(int[] arr, int x, int v) {
        for (int i = x + 1; i < arr.length; i += i & (-i)) {
            arr[i] += v;
        }
    }

    private int sum(int[] arr, int x) {
        int ret = 0;
        for (int i = x + 1; i > 0; i -= i & (-i)) {
            ret += arr[i];
        }
        return ret;
    }

    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        int[] arr = new int[N + 1];
        Integer[] ret = new Integer[N];
        IntStream.range(0, N).boxed().sorted(Comparator.comparingInt(o -> nums[o])).forEach(idx -> {
            add(arr, idx, 1);
            ret[idx] = sum(arr, N - 1) - sum(arr, idx);
        });
        return Arrays.asList(ret);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5, 2, 6, 1}));
    }
}
