package match.weekly.weekly184.p2;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] ret = new int[queries.length];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= m; ++i) {
            list.add(i);
        }
        for (int i = 0; i < queries.length; ++i) {
            int idx = list.indexOf(queries[i]);
            ret[i] = idx;
            list.remove(idx);
            list.addFirst(queries[i]);
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().processQueries(new int[]{3, 1, 2, 1}, 5)));
        System.out.println(Arrays.toString(new Solution().processQueries(new int[]{4, 1, 2, 2}, 4)));
        System.out.println(Arrays.toString(new Solution().processQueries(new int[]{7, 5, 5, 8, 3}, 8)));
    }
}
