package normal.cat0.cat00.cat005.p51.v1

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val shu = Array(n) { false }
        val pie = Array(2 * n - 1) { false }
        val na = Array(2 * n - 1) { false }
        val ret = ArrayList<List<String>>()

        fun dfs(has: ArrayDeque<Int>) {
            if (has.size >= n) {
                ret += has.map { col -> CharArray(n) { if (it == col) 'Q' else '.' } .joinToString(separator = "") }
                return
            }
            for (i in 0 until n) {
                val idxPie = has.size + i
                val idxNa = n - i - 1 + has.size
                if (shu[i] || pie[idxPie] || na[idxNa]) {
                    continue
                }
                shu[i] = true
                pie[idxPie] = true
                na[idxNa] = true
                has.addLast(i)
                dfs(has)
                has.removeLast()
                shu[i] = false
                pie[idxPie] = false
                na[idxNa] = false
            }
        }
        dfs(ArrayDeque())
        return ret
    }
}

fun main() {
    println(Solution().solveNQueens(4))
    println(Solution().solveNQueens(8))
    println(Solution().solveNQueens(12).size)
    println(Solution().solveNQueens(14).size)
}