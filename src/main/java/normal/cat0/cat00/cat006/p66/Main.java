package normal.cat0.cat00.cat006.p66;

import utils.java.DebugUtils;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int ext = 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i] += ext;
            ext = digits[i] / 10;
            digits[i] %= 10;
        }
        if (ext != 0) {
            int[] ret = new int[digits.length + 1];
            System.arraycopy(digits, 0, ret, 1, digits.length);
            ret[0] = 1;
            return ret;
        } else {
            return digits;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(DebugUtils.parseIntArr1("[1,2,3]"))));
        System.out.println(Arrays.toString(new Solution().plusOne(DebugUtils.parseIntArr1("[9,9,9]"))));
        System.out.println(Arrays.toString(new Solution().plusOne(DebugUtils.parseIntArr1("[4,3,2,1]"))));
    }
}
