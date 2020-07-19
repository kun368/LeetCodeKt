package normal.cat1.cat15.cat151.p1515;

import utils.java.DebugUtils;

class Solution {

    private static final double[][] dir = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final double ABS = 1e-7;

    public double calcDis(int[][] positions, double x, double y) {
        double ret = 0.0;
        for (int[] p : positions) {
            ret += Math.sqrt(Math.pow(x - p[0], 2) + Math.pow(y - p[1], 2));
        }
        return ret;
    }

    public double getMinDistSum(int[][] positions) {
        double x = positions[0][0], y = positions[0][1];
        double abs = 1;
        while (abs > ABS) {
            double minDis = Double.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < dir.length; ++i) {
                double curDis = calcDis(positions, x + dir[i][0] * abs, y + dir[i][1] * abs);
                if (curDis < minDis) {
                    minDis = curDis;
                    minIdx = i;
                }
            }
            x += dir[minIdx][0] * abs;
            y += dir[minIdx][1] * abs;
            abs *= 0.995;
        }
        return calcDis(positions, x, y);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getMinDistSum(DebugUtils.parseIntArr2("[[1,1],[3,3]]")));
        System.out.println(new Solution().getMinDistSum(DebugUtils.parseIntArr2("[[1,1]]")));
        System.out.println(new Solution().getMinDistSum(DebugUtils.parseIntArr2("[[1,1],[0,0],[2,0]]")));
        System.out.println(new Solution().getMinDistSum(DebugUtils.parseIntArr2("[[0,1],[3,2],[4,5],[7,6],[8,9],[11,1],[2,12]]")));
        System.out.println(new Solution().getMinDistSum(DebugUtils.parseIntArr2("[[88,76],[21,33],[19,30],[35,32],[19,30],[84,80],[77,65],[30,16],[33,17],[19,27],[72,68],[23,36],[16,21],[67,69],[34,33],[85,78],[29,37],[24,18],[83,71],[79,74],[36,23],[94,64],[24,20],[71,80],[88,77],[21,16],[35,20],[90,78],[86,71],[79,65],[24,21]]")));

    }
}
