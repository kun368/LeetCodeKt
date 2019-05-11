package cat020.p200.v1

class Solution {

    private fun extend(g: Array<CharArray>, x: Int, y: Int) {
        if (x < 0 || y < 0 || x >= g.size || y >= g[0].size || g[x][y] != '1') return
        g[x][y] = '2'
        extend(g, x + 1, y)
        extend(g, x, y + 1)
        extend(g, x - 1, y)
        extend(g, x, y - 1)
    }

    fun numIslands(g: Array<CharArray>): Int {
        var cnt = 0
        for (i in 0 until g.size) {
            for (j in 0 until g[0].size) {
                if (g[i][j] == '1') {
                    cnt += 1
                    extend(g, i, j)
                }
            }
        }
        return cnt
    }
}

fun main(args: Array<String>) {
    println(Solution().numIslands(arrayOf(
            "11110".toCharArray(),
            "11010".toCharArray(),
            "11000".toCharArray(),
            "00000".toCharArray()
    )))
    println(Solution().numIslands(arrayOf(
            "11000".toCharArray(),
            "11000".toCharArray(),
            "00100".toCharArray(),
            "00011".toCharArray()
    )))
}