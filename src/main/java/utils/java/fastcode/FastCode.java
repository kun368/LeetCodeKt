package utils.java.fastcode;

public class FastCode {

    // 10^9 + 7
    public static final long MOD = 1000000007;

    // → ↓ ← ↑
    private static final int[][] dir = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // MAX
    private static final int MAX = 0x3f3f3f3f;

    private static int lowerBound(int[] a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a[middle]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    private static int upperBound(int[] a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (a[middle] > element) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }
}
