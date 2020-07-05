package match.weekly.weekly196.p2;


class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int i : left) {
            ans = Math.max(ans, i);
        }
        for (int i : right) {
            ans = Math.max(ans, n - i);
        }
        return ans;
    }
}

/**
 * @author kunwu
 * @date 2020/7/5 10:22 上午
 */
public class Main {
    public static void main(String[] args) {

    }
}
