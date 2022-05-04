package normal.cat2.cat22.p2249;

import utils.java.ArrayInputUtils;

class Solution {
    public int countLatticePoints(int[][] circles) {
        boolean[][] vis = new boolean[210][210];
        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            for (int i = -r; i <= r; ++i) {
                for (int j = -r; j <= r; ++j) {
                    if (i * i + j * j > r * r) continue;
                    vis[x + i][y + j] = true;
                }
            }
        }
        int cnt = 0;
        for (boolean[] vi : vis) {
            for (boolean i : vi) if (i) cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countLatticePoints(ArrayInputUtils.parseIntArr2("[[2,2,1]]")));
        System.out.println(new Solution().countLatticePoints(ArrayInputUtils.parseIntArr2("[[2,2,2],[3,4,1]]")));
        System.out.println(new Solution().countLatticePoints(ArrayInputUtils.parseIntArr2(
                "[[8,9,6],[9,8,4],[4,1,1],[8,5,1],[7,1,1],[6,7,5],[7,1,1],[7,1,1],[5,5,3]]"))); // 141
    }
}
