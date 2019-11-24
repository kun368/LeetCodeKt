package match.weekly164.p1;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            int dx = Math.abs(points[i][0] - points[i + 1][0]);
            int dy = Math.abs(points[i][1] - points[i + 1][1]);
            ans += Math.max(dx, dy);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minTimeToVisitAllPoints(new int[][]{
                {1, 1},
                {3, 4},
                {-1, 0},
        }));
        System.out.println(new Solution().minTimeToVisitAllPoints(new int[][]{
                {3, 2},
                {-2, 2},
        }));
        System.out.println(new Solution().minTimeToVisitAllPoints(new int[][]{
                {1, 1},
        }));
    }
}
