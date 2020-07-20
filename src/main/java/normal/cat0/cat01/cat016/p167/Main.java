package normal.cat0.cat01.cat016.p167;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; ++i) {
            int L = i + 1, R = numbers.length;
            while (L < R) {
                int mid = (L + R) / 2;
                if (numbers[i] + numbers[mid] == target) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[i] + numbers[mid] < target) {
                    L = mid + 1;
                } else {
                    R = mid;
                }
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{5, 25, 75}, 100)));
    }
}
