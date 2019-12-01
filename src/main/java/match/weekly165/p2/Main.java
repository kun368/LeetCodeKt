package match.weekly165.p2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> numOfBurgers(int t, int c) {
        int x = t - 2 * c;
        if (x % 2 != 0) {
            return Collections.emptyList();
        }
        x /= 2;
        int y = c - x;
        if (x >= 0 && y >= 0) {
            return Arrays.asList(x, y);
        } else {
            return Collections.emptyList();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfBurgers(16, 7));
        System.out.println(new Solution().numOfBurgers(17, 4));
        System.out.println(new Solution().numOfBurgers(4, 17));
        System.out.println(new Solution().numOfBurgers(0, 0));
        System.out.println(new Solution().numOfBurgers(2, 1));

    }
}
