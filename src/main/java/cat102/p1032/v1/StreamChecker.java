package cat102.p1032.v1;

import java.util.ArrayList;
import java.util.List;

class StreamChecker {

    class Node {
        boolean val;
        Node[] chi = new Node[27];

        Node(boolean val) {
            this.val = val;
        }
    }

    private Node root = new Node(false);
    private List<Integer> sb = new ArrayList<>();

    public StreamChecker(String[] words) {
        for (String word : words) {
            String s = new StringBuilder(word).reverse().toString();
            Node cur = root;
            for (int i = 0; i < s.length(); ++i) {
                int c = s.charAt(i) - 'a';
                if (cur.chi[c] == null) {
                    cur.chi[c] = new Node(false);
                }
                cur = cur.chi[c];
            }
            cur.val = true;
        }
    }

    public boolean query(char letter) {
        sb.add(letter - 'a');
        Node cur = root;
        for (int i = sb.size() - 1; i >= 0; --i) {
            Node next = cur.chi[sb.get(i)];
            if (next == null) {
                return false;
            } else if (next.val) {
                return true;
            }
            cur = next;
        }
        return false;
    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{
                "cd", "f", "kl"
        });
        System.out.println(streamChecker.query('a'));          // 返回 false
        System.out.println(streamChecker.query('b'));          // 返回 false
        System.out.println(streamChecker.query('c'));          // 返回 false
        System.out.println(streamChecker.query('d'));          // 返回 true，因为 'cd' 在字词表中
        System.out.println(streamChecker.query('e'));          // 返回 false
        System.out.println(streamChecker.query('f'));          // 返回 true，因为 'f' 在字词表中
        System.out.println(streamChecker.query('g'));          // 返回 false
        System.out.println(streamChecker.query('h'));          // 返回 false
        System.out.println(streamChecker.query('i'));          // 返回 false
        System.out.println(streamChecker.query('j'));          // 返回 false
        System.out.println(streamChecker.query('k'));          // 返回 false
        System.out.println(streamChecker.query('l'));          // 返回 true，因为 'kl' 在字词表中。
    }
}