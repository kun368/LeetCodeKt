package cat010.p104.v1

import utils.kotlin.TreeNode

class Solution {
    fun maxDepth(root: TreeNode?): Int = if (root == null) 0 else maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
}
