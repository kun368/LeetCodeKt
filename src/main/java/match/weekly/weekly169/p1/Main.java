package match.weekly.weekly169.p1;

import java.util.Arrays;

class Solution {
    public int[] sumZero(int n) {
        int[] ret = new int[n];
        int sum = 0;
        for (int i = 0; i < n -1; ++i) {
            ret[i] = i + 1;
            sum += ret[i];
        }
        ret[n - 1] = -sum;
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 10; ++i) {
            System.out.println(i);
            System.out.println(Arrays.toString(new Solution().sumZero(i)));
        }
    }
}
