package cat017.p173.v1;

import utils.java.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树迭代器
 */
class BSTIterator {

    private Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        addTop(root);
    }

    private void addTop(TreeNode t) {
        if (t == null) return;
        stack.add(t);
        while (stack.getLast().left != null) {
            stack.add(stack.getLast().left);
        }
    }

    private TreeNode removeTop() {
        TreeNode top = stack.pollLast();
        if (top == null) return null;
        if (top.right != null) {
            addTop(top.right);
        }
        return top;
    }

    public int next() {
        TreeNode top = removeTop();
        return top == null ? -1 : top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7,
                new TreeNode(3),
                new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());    // 返回 3
        System.out.println(iterator.next());    // 返回 7
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 9
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 15
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 20
        System.out.println(iterator.hasNext()); // 返回 false
    }
}
