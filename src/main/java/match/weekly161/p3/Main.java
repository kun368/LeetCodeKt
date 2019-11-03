package match.weekly161.p3;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ret = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt += 1;
            } else if (c == ')') {
                cnt -= 1;
            }
            if (cnt < 0) {
                cnt = 0;
            } else {
                ret.append(c);
            }
        }
        // System.out.println("cnt = " + cnt + ", t = " + ret.toString());
        while (cnt > 0) {
            ret.deleteCharAt(ret.lastIndexOf("("));
            cnt -= 1;
        }
        return ret.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new Solution().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new Solution().minRemoveToMakeValid("))(("));
        System.out.println(new Solution().minRemoveToMakeValid("(a(b(c)d)"));
    }
}
