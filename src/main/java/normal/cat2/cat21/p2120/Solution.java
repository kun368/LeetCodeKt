package normal.cat2.cat21.p2120;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static final Map<Character, List<Integer>> dir = new HashMap<>();

    static {
        dir.put('L', Arrays.asList(0, -1));
        dir.put('R', Arrays.asList(0, 1));
        dir.put('U', Arrays.asList(-1, 0));
        dir.put('D', Arrays.asList(1, 0));
    }


    private boolean check(int n, int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private int run(int n, int x, int y, String s) {
        for (int i = 0; i < s.length(); ++i) {
            int xx = x + dir.get(s.charAt(i)).get(0);
            int yy = y + dir.get(s.charAt(i)).get(1);
            if (!check(n, xx, yy)) return i;
            x = xx;
            y = yy;
        }
        return s.length();
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ret = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            ret[i] = run(n, startPos[0], startPos[1], s.substring(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
        System.out.println(Arrays.toString(new Solution().executeInstructions(2, new int[]{1, 1}, "LURD")));
        System.out.println(Arrays.toString(new Solution().executeInstructions(1, new int[]{0, 0}, "LRUD")));
    }
}
