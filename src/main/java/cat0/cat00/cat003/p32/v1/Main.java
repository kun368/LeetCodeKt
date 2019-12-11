package cat0.cat00.cat003.p32.v1;

import java.util.ArrayList;
import java.util.List;

class Solution {

    static class Span {
        public int L, R;

        public Span(int l, int r) {
            L = l;
            R = r;
        }
    }

    public int longestValidParentheses(String s) {
        List<Integer> st = new ArrayList<>();
        List<Span> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                st.add(i);
            } else if (!st.isEmpty()) {
                int match = st.remove(st.size() - 1);
                list.add(new Span(match, i + 1));
                while (list.size() >= 2) {
                    Span a = list.get(list.size() - 2);
                    Span b = list.get(list.size() - 1);
                    if (a.R >= b.L) {
                        list.remove(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(new Span(Math.min(a.L, b.L), b.R));
                    } else {
                        break;
                    }
                }
            }
        }
        int ans = 0;
        for (Span span : list) {
            ans = Math.max(ans, span.R - span.L);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses("()(())"));
    }
}
