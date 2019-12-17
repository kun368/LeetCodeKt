package match.weekly166.p1;

class Solution {
    public int subtractProductAndSum(int n) {
        String str = String.valueOf(n);
        int a = 1;
        int b = 0;
        for (int i = 0; i < str.length(); ++i) {
            a *= str.charAt(i) - '0';
            b += str.charAt(i) - '0';
        }
        return a - b;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().subtractProductAndSum(234));
        System.out.println(new Solution().subtractProductAndSum(4421));
    }
}
