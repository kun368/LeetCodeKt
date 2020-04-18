package match.season.spring2020.p1;

class Solution {
    public int minCount(int[] coins) {
        int ans = 0;
        for (int i : coins) {
            ans += (i + 1) / 2;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
