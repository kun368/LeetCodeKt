package cat012.p124.v1

import utils.TreeNode

// TODO solve
class Solution {
    fun maxPathSum(root: TreeNode): Int {
        var max: Int = root.`val`
        fun dfs(root: TreeNode?): Int = if (root == null) 0 else {
            val sum = root.`val`
            val sum1 = sum + dfs(root.left)
            val sum2 = sum + dfs(root.right)
            val sum3 = sum1 + sum2 - sum
            val curMax: Int = maxOf(sum, maxOf(sum1, sum2, sum3))
            max = maxOf(max, curMax)
            curMax
        }
        dfs(root)
        return max
    }
}