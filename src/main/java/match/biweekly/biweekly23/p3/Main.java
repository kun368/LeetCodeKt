package match.biweekly.biweekly23.p3;

class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        for (int i = x_center - radius; i <= x_center + radius; ++i) {
            for (int j = y_center - radius; j <= y_center + radius; ++j) {
                long dx = Math.abs(i - x_center) * Math.abs(i - x_center);
                long dy = Math.abs(j - y_center) * Math.abs(j - y_center);
                if (dx + dy > radius * radius) {
                    continue;
                }
                if (i < Math.min(x1, x2) || i > Math.max(x1, x2)) {
                    continue;
                }
                if (j < Math.min(y1, y2) || j > Math.max(y1, y2)) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println(new Solution().checkOverlap(1, 0, 0, -1, 0, 0, 1));
        System.out.println(new Solution().checkOverlap(1, 1, 1, -3, -3, 3, 3));
        System.out.println(new Solution().checkOverlap(1, 1, 1, 1, -3, 2, -1));
        System.out.println(new Solution().checkOverlap(1415, 807, -784, -733, 623, -533, 1005));
    }
}
