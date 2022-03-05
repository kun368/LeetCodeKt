package normal.cat2.cat21.p2165;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long smallestNumber(long num) {
        if (num == 0) {
            return num;
        }
        int zero = 0;
        List<Integer> ls = new ArrayList<>();
        String s = String.valueOf(Math.abs(num));
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') zero += 1;
            else ls.add(s.charAt(i) - '0');
        }
        Collections.sort(ls);
        long ret = 0;

        if (num > 0) {
            for (int i = 0; i < ls.size(); ++i) {
                ret = ret * 10 + ls.get(i);
                if (i == 0) {
                    for (int j = 0; j < zero; ++j) ret = ret * 10;
                }
            }
        } else {
            for (int i = ls.size() - 1; i >= 0; --i) {
                ret = ret * 10 + ls.get(i);
                if (i == 0) {
                    for (int j = 0; j < zero; ++j) ret = ret * 10;
                }
            }
            ret *= -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber(310));
        System.out.println(new Solution().smallestNumber(-7605));
    }
}
