package match.biweekly.biweekly33.p3;

class Solution {
    public int minOperations(int[] nums) {
        int multi = 0;
        int add = 0;
        for (int i : nums) {
            int beiT = 0;
            while (i != 0) {
                if (i % 2 == 1) {
                    i -= 1;
                    add += 1;
                } else {
                    i >>= 1;
                    ++beiT;
                }
            }
            if (multi < beiT) {
                multi = beiT;
            }
        }
        return multi + add;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
    }
}
