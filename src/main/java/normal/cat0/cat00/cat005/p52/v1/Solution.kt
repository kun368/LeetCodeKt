package normal.cat0.cat00.cat005.p52.v1

class Solution {
    fun totalNQueens(n: Int): Int {
        val shu = Array(n) { false }
        val pie = Array(2 * n - 1) { false }
        val na = Array(2 * n - 1) { false }
        var count = 0

        fun dfs(has: Int = 0) {
            if (has >= n) {
                count += 1
                return
            }
            for (i in 0 until n) {
                val idxPie = has + i
                val idxNa = n - i - 1 + has
                if (shu[i] || pie[idxPie] || na[idxNa]) {
                    continue
                }
                shu[i] = true
                pie[idxPie] = true
                na[idxNa] = true
                dfs(has + 1)
                shu[i] = false
                pie[idxPie] = false
                na[idxNa] = false
            }
        }
        dfs()
        return count
    }
}


fun main() {
    println(Solution().totalNQueens(4))
    println(Solution().totalNQueens(8))
    println(Solution().totalNQueens(12))
    println(Solution().totalNQueens(14))
}