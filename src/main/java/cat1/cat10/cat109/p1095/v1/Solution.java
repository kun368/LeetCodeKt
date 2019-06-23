package cat1.cat10.cat109.p1095.v1;

import java.util.Arrays;
import java.util.List;

interface MountainArray {
    public int get(int index);

    public int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int len = arr.length();
        int l = 1;
        int r = len - 1;
        while (true) {
            int mid = (l + r) / 2;
            int a = arr.get(mid - 1);
            int b = arr.get(mid);
            int c = arr.get(mid + 1);
            if (a < b && b > c) {
                break;
            }
            if (a > b) r = mid;
            if (b < c) l = mid + 1;
        }
        int topIdx = (l + r) / 2;
        int left = bfind(target, arr, 0, topIdx + 1, true);
        if (left != -1) {
            return left;
        }
        return bfind(target, arr, topIdx, len, false);
    }

    private int bfind(int target, MountainArray arr, int l, int r, boolean asc) {
        while (l < r) {
            int mid = (l + r) / 2;
            int v = arr.get(mid);
            if (v == target) {
                return mid;
            } else if ((asc && v < target) || (!asc && v > target)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = new Solution().findInMountainArray(1, new MountainArray() {

            List<Integer> arr = Arrays.asList(0, 5, 3, 1);

            @Override
            public int get(int index) {
                return arr.get(index);
            }

            @Override
            public int length() {
                return arr.size();
            }
        });
        System.out.println(ans);
    }
}