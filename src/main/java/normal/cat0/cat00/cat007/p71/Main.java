package normal.cat0.cat00.cat007.p71;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (s.isEmpty() || ".".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(s);
            }
        }
        StringJoiner sj = new StringJoiner("/", "/", "");
        for (String s : stack) {
            sj.add(s);
        }
        return sj.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new Solution().simplifyPath("/a//b////c/d//././/.."));
    }
}
