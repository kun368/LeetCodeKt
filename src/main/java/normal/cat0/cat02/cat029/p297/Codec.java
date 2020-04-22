package normal.cat0.cat02.cat029.p297;

import utils.java.TreeNode;

import java.util.StringJoiner;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringJoiner sj = new StringJoiner(",", "[", "]");
        sj.add(String.valueOf(root.val));
        sj.add(serialize(root.left));
        sj.add(serialize(root.right));
        return sj.toString();
    }

    static class Node {
        int endIdx;
        TreeNode tree;
    }

    public TreeNode deserialize(String data) {
        return deserialize(data, 0).tree;
    }

    private Node deserialize(String data, int start) {
        Node node = new Node();
        if (data.charAt(start) == '[') {
            int pos = data.indexOf(",", start + 1);
            node.tree = new TreeNode(Integer.parseInt(data.substring(start + 1, pos)));
            Node nl = deserialize(data, pos + 1);
            node.tree.left = nl.tree;
            Node nr = deserialize(data, nl.endIdx + 2);
            node.tree.right = nr.tree;
            node.endIdx = nr.endIdx + 1;
        } else if (data.charAt(start) == 'n') {
            node.endIdx = start + 3;
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new Codec().serialize(TreeNode.parse("[1,2,3,null,null,4,5]")));
        System.out.println(new Codec().serialize(null));
        System.out.println(new Codec().deserialize("[1,[2,null,null],[3,[4,null,null],[5,null,null]]]"));
        System.out.println(new Codec().deserialize("null"));
    }
}