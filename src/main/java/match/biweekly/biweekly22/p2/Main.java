package match.biweekly.biweekly22.p2;

import utils.java.DebugUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Set<String> set = new HashSet<>();
        Set<Integer> hasRow = new HashSet<>();
        for (int[] i : reservedSeats) {
            set.add(i[0] + "#" + i[1]);
            hasRow.add(i[0]);
        }
        int cnt = (n - hasRow.size()) * 2;
        for (Integer i : hasRow) {
            for (int st : Arrays.asList(2, 4, 6)) {
                boolean ok = true;
                for (int j = st; j < st + 4; ++j) {
                    if (set.contains(i + "#" + j)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    for (int j = st; j < st + 4; ++j) {
                        set.add(i + "#" + j);
                    }
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxNumberOfFamilies(3, DebugUtils.parseIntArr2("[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]")));
        System.out.println(new Solution().maxNumberOfFamilies(2, DebugUtils.parseIntArr2("[[2,1],[1,8],[2,6]]")));
        System.out.println(new Solution().maxNumberOfFamilies(4, DebugUtils.parseIntArr2("[[4,3],[1,4],[4,6],[1,7]]")));
        System.out.println(new Solution().maxNumberOfFamilies(400000000, DebugUtils.parseIntArr2("[[4,3],[1,4],[4,6],[1,7]]")));
    }
}
