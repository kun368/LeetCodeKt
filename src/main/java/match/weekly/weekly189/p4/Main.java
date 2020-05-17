package match.weekly.weekly189.p4;


import utils.java.DebugUtils;

import static java.lang.Math.*;

class Solution {

    public static final double ERR = 1e-7;

    private int N;
    private double R;
    private int[][] points;

    double distance(double x1, double y1, double x2, double y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    double distance(int i, int j) {
        return distance(points[i][0], points[i][1], points[j][0], points[j][1]);
    }

    int countInner(double cx, double cy) {
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            double d = distance(cx, cy, points[i][0], points[i][1]);
            if (d <= R * R + ERR) {
                cnt += 1;
            }
        }
        return cnt;
    }

    int circleCenterCheck(double x1, double y1, double x2, double y2) {
        double y01, x01, x02, y02;
        if (Math.abs(x1 - x2) < ERR) {
            y01 = (y1 + y2) / 2;
            y02 = (y1 + y2) / 2;
            double d = sqrt(pow(R, 2) - pow(abs(y1 - y2) / 2, 2));
            x01 = x1 + d;
            x02 = x1 - d;
        } else {
            double c1, c2, A, B, C;
            c1 = (pow(x2, 2) - pow(x1, 2) + pow(y2, 2) - pow(y1, 2)) / 2 / (x2 - x1);
            c2 = (y2 - y1) / (x2 - x1);
            A = 1.0 + pow(c2, 2);
            B = 2 * (x1 - c1) * c2 - 2 * y1;
            C = pow((x1 - c1), 2) + pow(y1, 2) - pow(R, 2);
            double tmp = B * B - 4 * A * C;
            y01 = (-B + sqrt(tmp)) / 2 / A;
            x01 = c1 - c2 * y01;
            y02 = (-B - sqrt(tmp)) / 2 / A;
            x02 = c1 - c2 * y01;
        }
        return Math.max(countInner(x01, y01), countInner(x02, y02));
    }

    public int numPoints(int[][] points, int r) {
        this.points = points;
        this.N = points.length;
        this.R = r;
        int ans = 1;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (sqrt(distance(i, j)) > r * 2 + ERR) {
                    continue;
                }
                int check = circleCenterCheck(points[i][0], points[i][1], points[j][0], points[j][1]);
                ans = Math.max(ans, check);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numPoints(DebugUtils.parseIntArr2(
                "[[-2,0],[2,0],[0,2],[0,-2]]"), 2));
        System.out.println(new Solution().numPoints(DebugUtils.parseIntArr2(
                "[[-3,0],[3,0],[2,6],[5,4],[0,9],[7,8]]"), 5));
        System.out.println(new Solution().numPoints(DebugUtils.parseIntArr2(
                "[[-2,0],[2,0],[0,2],[0,-2]]"), 1));
        System.out.println(new Solution().numPoints(DebugUtils.parseIntArr2(
                "[[1,2],[3,5],[1,-1],[2,3],[4,1],[1,3]]"), 2));
    }
}
