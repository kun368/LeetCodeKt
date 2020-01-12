package match.weekly171.p2;

import java.math.BigInteger;

class Solution {
    public int minFlips(int a, int b, int c) {
        BigInteger aa = new BigInteger(String.valueOf(a));
        BigInteger bb = new BigInteger(String.valueOf(b));
        BigInteger cc = new BigInteger(String.valueOf(c));
        int ans = 0;
        for (int i = 0; i <= 32; ++i) {
            if (cc.testBit(i)) {
                if (!aa.testBit(i) && !bb.testBit(i))
                    ans += 1;
            } else {
                if (aa.testBit(i)) ans += 1;
                if (bb.testBit(i)) ans += 1;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minFlips(2, 6, 5));
        System.out.println(new Solution().minFlips(4, 2, 7));
        System.out.println(new Solution().minFlips(1, 2, 3));
    }
}
