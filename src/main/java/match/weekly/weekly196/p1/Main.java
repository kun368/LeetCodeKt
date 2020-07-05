package match.weekly.weekly196.p1;


import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if (arr.length <= 2) {
            return true;
        }
        int d = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; ++i) {
            if (d != arr[i + 1] - arr[i]) {
                return false;
            }
        }
        return true;
    }
}

/**
 * @author kunwu
 * @date 2020/7/5 10:22 上午
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("1");
    }
}
