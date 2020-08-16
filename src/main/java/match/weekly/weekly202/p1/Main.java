package match.weekly.weekly202.p1;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i + 2 < arr.length; ++i) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
    }
}
