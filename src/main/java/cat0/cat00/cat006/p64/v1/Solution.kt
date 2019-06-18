package cat0.cat00.cat006.p64.v1

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = hashMapOf<String, Int>()
        fun dfs(x: Int, y: Int): Int {
            if (x < 0 || y < 0) {
                return Int.MAX_VALUE / 2
            }
            if (x == 0 && y == 0) {
                return grid[0][0]
            }
            val key = "$x#$y"
            dp[key]?.apply { return this }
            val ans = grid[x][y] + minOf(dfs(x, y - 1), dfs(x - 1, y))
            dp[key] = ans
            return ans
        }
        return dfs(grid.lastIndex, grid[0].lastIndex)
    }
}

fun main(args: Array<String>) {
    println(Solution().minPathSum(arrayOf(
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 1),
            intArrayOf(4, 2, 1)
    )))
}