package match.weekly.weekly194.p1;

class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans ^= (start + i * 2);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
    }
}
