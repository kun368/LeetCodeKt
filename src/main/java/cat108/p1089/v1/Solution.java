package cat108.p1089.v1;

import java.util.Arrays;

class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] != 0) continue;
            for (int j = arr.length - 1; j > i; --j) {
                arr[j] = arr[j - 1];
            }
            i += 1;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 0, 2, 3, 0, 4, 5, 0};
        new Solution().duplicateZeros(ints);
        System.out.println(Arrays.toString(ints));

        ints = new int[]{1, 2, 3};
        new Solution().duplicateZeros(ints);
        System.out.println(Arrays.toString(ints));
    }
}