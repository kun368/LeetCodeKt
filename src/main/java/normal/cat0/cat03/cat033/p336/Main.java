package normal.cat0.cat03.cat033.p336;


import java.util.*;

/**
 * 336. 回文对
 * 字典树 正反双向匹配 + 长的部分单独校验是否回文
 * 写的有点啰嗦...
 */
class Solution {

    static class Node {
        Node[] children = new Node[27];
        List<Integer> match1 = new ArrayList<>();
        List<Integer> match2 = new ArrayList<>();
    }

    private Node initTree(String[] words) {
        Node root = new Node();
        for (int s = 0; s < words.length; ++s) {
            if (words[s].length() == 0) {
                root.match1.add(s);
                root.match2.add(s);
                continue;
            }
            Node curr = root;
            for (int i = 0; i < words[s].length(); ++i) {
                int c = words[s].charAt(i) - 'a';
                if (curr.children[c] == null) curr.children[c] = new Node();
                curr = curr.children[c];
            }
            curr.match1.add(s);
            curr = root;
            for (int i = words[s].length() - 1; i >= 0; --i) {
                int c = words[s].charAt(i) - 'a';
                if (curr.children[c] == null) curr.children[c] = new Node();
                curr = curr.children[c];
            }
            curr.match2.add(s);
        }
        return root;
    }

    // a: abcd, b: cba
    // a: abcd, b: edcba
    private boolean valid(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) return false;
        if (a.length() == b.length()) return true;
        String ext = a.length() > b.length() ? a.substring(b.length()) : b.substring(0, b.length() - a.length());
        for (int i = 0; i < ext.length() / 2; ++i) {
            if (ext.charAt(i) != ext.charAt(ext.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> ret = new HashSet<>();
        Node root = initTree(words);
        for (int i = 0; i < words.length; ++i) {
            String s = words[i];
            Node curr = root;
            for (Integer k : curr.match2) {
                if (i != k && valid(words[i], words[k])) {
                    ret.add(Arrays.asList(i, k));
                }
            }
            for (int j = 0; j < s.length(); ++j) {
                curr = curr.children[s.charAt(j) - 'a'];
                for (Integer k : curr.match2) {
                    if (i != k && valid(words[i], words[k])) {
                        ret.add(Arrays.asList(i, k));
                    }
                }
            }
            curr = root;
            for (Integer k : curr.match1) {
                if (i != k && valid(words[k], words[i])) {
                    ret.add(Arrays.asList(k, i));
                }
            }
            for (int j = s.length() - 1; j >= 0; --j) {
                curr = curr.children[s.charAt(j) - 'a'];
                for (Integer k : curr.match1) {
                    if (i != k && valid(words[k], words[i])) {
                        ret.add(Arrays.asList(k, i));
                    }
                }
            }
        }
        return new ArrayList<>(ret);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(new Solution().palindromePairs(new String[]{"bat", "tab", "cat"}));
        System.out.println(new Solution().palindromePairs(new String[]{"a", ""}));
        System.out.println(new Solution().palindromePairs(new String[]{"", ""}));
    }
}
