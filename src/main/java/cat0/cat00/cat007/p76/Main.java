package cat0.cat00.cat007.p76;

import java.util.*;

/**
 * 类似双指针，利用一个队列，维护符合条件的字母列表；每次指针向右扩展时候，左指针也往右扩展缩短可行解
 */
class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        int[] tcnt = new int[130];
        int[] scnt = new int[130];
        for (int i = 0; i < t.length(); ++i) {
            tcnt[t.charAt(i)] += 1;
        }
        boolean full = false;
        String ans = "";
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i);
            if (tcnt[c] == 0) {
                continue;
            }
            scnt[c] += 1;
            qu.add(i);
            if (!full) {
                boolean ok = true;
                for (int j = 0; j < scnt.length; ++j) {
                    if (scnt[j] < tcnt[j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) full = true;
            }
            if (full) {
                while (!qu.isEmpty()) {
                    int top = s.charAt(qu.peek());
                    if (scnt[top] > tcnt[top]) {
                        qu.poll();
                        scnt[top] -= 1;
                    } else {
                        break;
                    }
                }
                int curStart = qu.isEmpty() ? 0 : qu.peek();
                if (ans.length() == 0 || ans.length() > (i - curStart + 1)) {
                    ans = s.substring(curStart, i + 1);
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("a", "a"));
    }
}
