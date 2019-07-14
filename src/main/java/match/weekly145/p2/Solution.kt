package match.weekly145.p2

import utils.kotlin.TreeNode

class Solution {
    fun lcaDeepestLeaves(root: TreeNode): TreeNode {
        fun findMax(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            return maxOf(findMax(root.left), findMax(root.right)) + 1
        }
        val maxh = findMax(root)
        println("maxh = $maxh")

        fun dfs(root: TreeNode?, curh: Int): TreeNode? {
            if (curh == maxh) {
                return root
            }
            if (root == null) {
                return null
            }
            val lres = dfs(root.left, curh + 1)
            val rres = dfs(root.right, curh + 1)
            if (lres != null && rres != null) {
                return root
            }
            if (lres != null) return lres
            if (rres != null) return rres
            return null
        }
        return dfs(root, 1)!!
    }
}