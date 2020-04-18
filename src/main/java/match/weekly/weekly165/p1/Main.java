package match.weekly.weekly165.p1;

class Solution {
    public String tictactoe(int[][] moves) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < moves.length; ++i) {
            int x = moves[i][0];
            int y = moves[i][1];
            arr[x][y] = (i % 2 == 0) ? 1 : 2;
        }
        for (int i = 0; i < 3; ++i) {
            if (arr[i][0] != 0 && arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2]) {
                return (arr[i][0] == 1) ? "A" : "B";
            }
        }
        for (int i = 0; i < 3; ++i) {
            if (arr[0][i] != 0 && arr[0][i] == arr[1][i] && arr[0][i] == arr[2][i]) {
                return (arr[0][i] == 1) ? "A" : "B";
            }
        }

        if (arr[0][0] != 0 && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) {
            return (arr[0][0] == 1) ? "A" : "B";
        }
        if (arr[0][2] != 0 && arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0]) {
            return (arr[0][2] == 1) ? "A" : "B";
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (arr[i][j] == 0)
                    return "Pending";
            }
        }
        return "Draw";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().tictactoe(new int[][]{
                {0, 0},
                {2, 0},
                {1, 1},
                {2, 1},
                {2, 2}
        }));
        System.out.println(new Solution().tictactoe(new int[][]{
                {0,0},{1,1},{0,1},{0,2},{1,0},{2,0}
        }));
        System.out.println(new Solution().tictactoe(new int[][]{
                {0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}
        }));
        System.out.println(new Solution().tictactoe(new int[][]{
                {0,0},{1,1}
        }));
    }
}
