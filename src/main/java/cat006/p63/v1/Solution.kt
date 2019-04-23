package cat006.p63.v1

class Solution {

    private val DIR = arrayOf(0 to 1, 1 to 0)

    fun uniquePathsWithObstacles(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        if (grid.first().first() != 0 || grid.last().last() != 0) {
            return 0
        }
        val ha = Array(m) { Array(n) { false } }
        var count = 0

        fun canSet(x: Int, y: Int) = x >= 0 && y >= 0 && x < m && y < n && !ha[x][y] && grid[x][y] == 0

        fun dfs(x: Int, y: Int) {
            if (x == m - 1 && y == n - 1) {
                count += 1
                return
            }
            ha[x][y] = true
            for (i in DIR) {
                val xx = x + i.first
                val yy = y + i.second
                if (canSet(xx, yy)) {
                    dfs(xx, yy)
                }
            }
            ha[x][y] = false
        }

        dfs(0, 0)
        return count
    }
}

fun main(args: Array<String>) {
    println(Solution().uniquePathsWithObstacles(arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
    )))
}
