package cat006.p62.v1

class Solution {

    private val DIR = arrayOf(0 to 1, 1 to 0)

    fun uniquePaths(m: Int, n: Int): Int {
        val ha = Array(m) { Array(n) { false } }
        var count = 0

        fun canSet(x: Int, y: Int) = x >= 0 && y >= 0 && x < m && y < n && !ha[x][y]

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
    println(Solution().uniquePaths(3, 2))
    println(Solution().uniquePaths(7, 3))

    for (i in 1..7) {
        for (j in 1..7) {
            println("$i, $j, ${Solution().uniquePaths(i, j)}")
        }
    }
    // 看出结论：ans[x][y] = ans[x-1][y-1]，其实就是dp
}