package normal.cat1.cat12.cat124.p1247;

class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (s1.charAt(i) == 'x') ++xy;
            else ++yx;
        }
        if ((xy + yx) % 2 != 0) {
            return -1;
        }
        return (xy / 2) + (yx / 2) + (xy % 2) + (yx % 2);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumSwap("xx", "yy"));
        System.out.println(new Solution().minimumSwap("xy", "yx"));
        System.out.println(new Solution().minimumSwap("xx", "xy"));
        System.out.println(new Solution().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
}
