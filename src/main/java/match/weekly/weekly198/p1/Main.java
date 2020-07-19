package match.weekly.weekly198.p1;


class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            ans += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numWaterBottles(9, 3));
        System.out.println(new Solution().numWaterBottles(15, 4));
        System.out.println(new Solution().numWaterBottles(5, 5));
        System.out.println(new Solution().numWaterBottles(2, 3));
    }
}
