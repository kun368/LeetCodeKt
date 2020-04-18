package match.weekly.weekly171.p1;

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; ++i) {
            int j = n - i;
            if (!String.valueOf(i).contains("0") && !String.valueOf(j).contains("0")) {
                return new int[]{i, j};
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
