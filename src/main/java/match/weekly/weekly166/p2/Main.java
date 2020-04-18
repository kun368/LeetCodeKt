package match.weekly.weekly166.p2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ret = new ArrayList<>();
        int N = groupSizes.length;
        for (int i = 1; i <= N; ++i) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < N; ++j) {
                if (groupSizes[j] == i) {
                    cur.add(j);
                }
                if (cur.size() == i) {
                    ret.add(new ArrayList<>(cur));
                    cur.clear();
                }
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(new Solution().groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }
}
