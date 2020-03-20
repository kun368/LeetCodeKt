package interview.p40;

import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
