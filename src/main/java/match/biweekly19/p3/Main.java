package match.biweekly19.p3;

class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12) {
            hour = 0;
        }
        double y = (minutes / 60.0) * 360.0;
        double x = (hour / 12.0) * 360.0 + (minutes / 60.0) * 30;
        double ans = Math.abs(x - y);
        if (ans > 180) {
            ans = 360 - ans;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().angleClock(12, 30));
        System.out.println(new Solution().angleClock(3, 30));
        System.out.println(new Solution().angleClock(3, 15));
        System.out.println(new Solution().angleClock(4, 50));
        System.out.println(new Solution().angleClock(12, 0));
    }
}
