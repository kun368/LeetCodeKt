package match.biweekly.biweekly32.p3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    private int get(String s, int i) {
        return s.charAt(i) == '(' ? 0 : 1;
    }

    public int minInsertions(String s) {
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            int cur = get(s, i);
            if (cur == 0) {
                list.add(0);
            } else {
                list.add(1);
                if (i + 1 < s.length() && get(s, i + 1) == 1) {
                    i += 1;
                } else {
                    cnt += 1;
                }
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (Integer i : list) {
            if (i == 0) {
                stack.add(0);
            } else {
                if (stack.size() > 0 && stack.getLast() == 0) {
                    stack.removeLast();
                } else {
                    cnt += 1;
                }
            }
        }
        cnt += stack.size() * 2;
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minInsertions("(()))"));
        System.out.println(new Solution().minInsertions("())"));
        System.out.println(new Solution().minInsertions("))())("));
        System.out.println(new Solution().minInsertions("(((((("));
        System.out.println(new Solution().minInsertions(")))))))"));
    }
}
