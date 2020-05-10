package match.weekly.weekly188.p2;


class Solution {

    private int[] pre;

    private int calc(int st, int ed) {
        return pre[ed] ^ (st == 0 ? 0 : pre[st - 1]);
    }

    public int countTriplets(int[] arr) {
        int t = 0;
        this.pre = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            t = t ^ arr[i];
            pre[i] = t;
        }
        int N = arr.length;
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                for (int k = j; k < N; ++k) {
                    if (calc(i, j - 1) == calc(j, k)) {
                        ans += 1;
                    }
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(new Solution().countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(new Solution().countTriplets(new int[]{2, 3}));
        System.out.println(new Solution().countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(new Solution().countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }
}
