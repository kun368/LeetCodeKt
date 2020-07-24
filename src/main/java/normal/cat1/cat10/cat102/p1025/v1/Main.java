package normal.cat1.cat10.cat102.p1025.v1;


class Solution {

    private static final Boolean[] dp = new Boolean[1024];

    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }
        if (dp[N] != null) {
            return dp[N];
        }
        dp[N] = false;
        int upper = (int) (Math.sqrt(N) + 1);
        for (int i = 1; i <= upper && i < N; ++i) {
            if (N % i == 0) {
                int j = N / i;
                if (!divisorGame(N - i) || (j > 0 && j < N && !divisorGame(N - j))) {
                    dp[N] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; ++i) {
            System.out.println("i = " + i + ", res = " + new Solution().divisorGame(i));
        }
    }
}
