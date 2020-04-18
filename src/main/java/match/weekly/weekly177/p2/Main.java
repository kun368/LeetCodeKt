package match.weekly.weekly177.p2;

import utils.java.DebugUtils;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> vis = new HashSet<>();
        for (int j : leftChild) {
            if (j == -1) continue;
            if (!vis.contains(j)) {
                vis.add(j);
            } else {
                return false;
            }
        }
        for (int j : rightChild) {
            if (j == -1) continue;
            if (!vis.contains(j)) {
                vis.add(j);
            } else {
                return false;
            }
        }

        int root = -1;
        for (int i = 0; i < n; ++i) {
            boolean found = false;
            for (int j : leftChild) {
                if (j == i) {
                    found = true;
                    break;
                }
            }
            for (int j : rightChild) {
                if (j == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
        }
        return root != -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().validateBinaryTreeNodes(4,
                DebugUtils.parseIntArr1("[1,-1,3,-1]"), DebugUtils.parseIntArr1("[2,-1,-1,-1]")));
        System.out.println(new Solution().validateBinaryTreeNodes(4,
                DebugUtils.parseIntArr1("[1,-1,3,-1]"), DebugUtils.parseIntArr1("[2,3,-1,-1]")));
        System.out.println(new Solution().validateBinaryTreeNodes(2,
                DebugUtils.parseIntArr1("[1,0]"), DebugUtils.parseIntArr1("[-1,-1]")));
        System.out.println(new Solution().validateBinaryTreeNodes(6,
                DebugUtils.parseIntArr1("[1,-1,-1,4,-1,-1]"), DebugUtils.parseIntArr1("[2,-1,-1,5,-1,-1]")));
    }
}
