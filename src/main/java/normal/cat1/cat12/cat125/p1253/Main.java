package normal.cat1.cat12.cat125.p1253;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        if (upper + lower != Arrays.stream(colsum).sum()) {
            return Collections.emptyList();
        }
        List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
        for (int sum : colsum) {
            if (sum == 0) {
                x.add(0);
                y.add(0);
            } else if (sum == 2) {
                x.add(1);
                y.add(1);
                upper -= 1;
                lower -= 1;
            } else if (sum == 1) {
                if (upper >= lower) {
                    x.add(1);
                    y.add(0);
                    upper -= 1;
                } else {
                    x.add(0);
                    y.add(1);
                    lower -= 1;
                }
            }
            // System.out.println("x = " + x + ", y = " + y + ", upper = " + upper + ", lower = " + lower);
            if (upper < 0 || lower < 0) {
                return Collections.emptyList();
            }
        }
        return Arrays.asList(x, y);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reconstructMatrix(2, 1, new int[]{1, 1, 1}));
        System.out.println(new Solution().reconstructMatrix(2, 3, new int[]{2, 2, 1, 1}));
        System.out.println(new Solution().reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
    }
}
