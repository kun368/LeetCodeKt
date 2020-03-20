package normal.cat0.cat00.cat006.p63.v1

class Solution {
    fun uniquePathsWithObstacles(grid: Array<IntArray>): Int {
        val dp = hashMapOf<String, Int>()
        fun dfs(x: Int, y: Int): Int {
            if (x < 0 || y < 0 || grid[x][y] != 0) {
                return 0
            }
            if (x == 0 && y == 0) {
                return 1
            }
            val key = "$x#$y"
            dp[key] ?. apply { return this }
            val ans = dfs(x, y - 1) + dfs(x - 1, y)
            dp[key] = ans
            return ans
        }
        return dfs(grid.lastIndex, grid[0].lastIndex)
    }
}

fun main(args: Array<String>) {
    println(Solution().uniquePathsWithObstacles(arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
    )))
    println(Solution().uniquePathsWithObstacles(arrayOf(
            intArrayOf(0, 0, 0)
    )))
    println(Solution().uniquePathsWithObstacles(arrayOf(
            intArrayOf(1)
    )))
    println(Solution().uniquePathsWithObstacles(arrayOf(
            intArrayOf(0),
            intArrayOf(0)
    )))
    println(Solution().uniquePathsWithObstacles(arrayOf(
            intArrayOf(1, 0)
    )))
}
