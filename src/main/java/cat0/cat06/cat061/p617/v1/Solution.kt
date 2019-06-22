package cat0.cat06.cat061.p617.v1

import utils.kotlin.TreeNode

/**
 * 617. 合并二叉树
 */
class Solution {
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if (t1 == null && t2 == null) {
            return null
        }
        if (t1 != null && t2 != null) {
            t1.`val` += t2.`val`
            t1.left = mergeTrees(t1.left, t2.left)
            t1.right = mergeTrees(t1.right, t2.right)
            return t1
        }
        return t1 ?: t2
    }
}