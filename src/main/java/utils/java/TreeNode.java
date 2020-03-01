package utils.java;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

@JSONType(orders = {"val", "left", "right"})
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 解析二叉树
     * 例如：[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     */
    public static TreeNode parse(String str) {
        Integer[] arr = Convert.toIntArray(DebugUtils.parseStrList1(str));
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        int idx = 0;
        TreeNode root = new TreeNode(arr[idx++]);
        List<TreeNode> roots = Collections.singletonList(root);
        while (idx < arr.length) {
            List<TreeNode> nextRoots = new ArrayList<>();
            for (TreeNode i : roots) {
                Integer cur = arr[idx++];
                if (cur != null) {
                    i.left = new TreeNode(cur);
                    nextRoots.add(i.left);
                }
                cur = arr[idx++];
                if (cur != null) {
                    i.right = new TreeNode(cur);
                    nextRoots.add(i.right);
                }
            }
            roots = nextRoots;
        }
        return root;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.PrettyFormat);
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.parse("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]"));
    }
}
