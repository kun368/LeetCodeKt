package match.biweekly.biweekly28.p1;

import java.util.Arrays;

class Solution {
    public int[] finalPrices(int[] prices) {
        int N = prices.length;
        int[] ret = new int[N];
        for (int i = 0; i < N; ++i) {
            ret[i] = prices[i];
            for (int j = i + 1; j < N; ++j) {
                if (prices[j] <= prices[i]) {
                    ret[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[]{10, 1, 1, 6})));
    }
}
