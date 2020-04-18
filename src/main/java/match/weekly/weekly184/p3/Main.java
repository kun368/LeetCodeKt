package match.weekly.weekly184.p3;

class Solution {

    private static final String[][] mp = new String[][]{
            {"&quot;", "\""},
            {"&apos;", "'"},
            {"&amp;", "&"},
            {"&gt;", ">"},
            {"&lt;", "<"},
            {"&frasl;", "/"},
    };

    public String entityParser(String text) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            if (c != '&') {
                ret.append(c);
                continue;
            }
            String[] ok = null;
            for (String[] ss : mp) {
                if (text.regionMatches(i, ss[0], 0, ss[0].length())) {
                    ok = ss;
                    break;
                }
            }
            if (ok != null) {
                ret.append(ok[1]);
                i += ok[0].length() - 1;
            } else {
                ret.append(c);
            }
        }
        return ret.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(new Solution().entityParser("and I quote: &quot;...&quot;"));
        System.out.println(new Solution().entityParser("Stay home! Practice on Leetcode :)"));
        System.out.println(new Solution().entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
        System.out.println(new Solution().entityParser("leetcode.com&frasl;problemset&frasl;all"));
    }
}
