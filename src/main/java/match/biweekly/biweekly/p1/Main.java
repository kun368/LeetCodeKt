package match.biweekly.biweekly.p1;

class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 0) {
            low += 1;
        }
        if (high % 2 == 0) {
            high -= 1;
        }
        return (high - low) / 2 + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countOdds(3, 7));
        System.out.println(new Solution().countOdds(8, 10));
        System.out.println(new Solution().countOdds(13, 18));
        System.out.println(new Solution().countOdds(1, 2));
        System.out.println(new Solution().countOdds(8, 10));
    }
}
