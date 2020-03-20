package normal.cat1.cat10.cat107.p1077.v1

import utils.kotlin.TreeNode

class Solution {
    fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
        fun dfs(root: TreeNode?, sum: Int): Boolean {
            if (root == null) return sum < limit
            val lres = dfs(root.left, sum + root.`val`)
            val rres = dfs(root.right, sum + root.`val`)
            if (lres && rres) return true
            if (lres) root.left = null
            if (rres) root.right = null
            return false
        }
        return if (dfs(root, 0)) null else root
    }
}