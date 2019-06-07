package cat107.p1072.v1

import java.math.BigInteger

/**
 * 按列翻转得到最大值等行数
 */
class Solution {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val mp = HashMap<BigInteger, Int>()
        for (i in matrix) {
            val t1 = BigInteger(i.joinToString(separator = ""), 2)
            val t2 = BigInteger(i.map { 1 - it }.joinToString(separator = ""), 2)
            mp.put(t1, mp.getOrElse(t1) { 0 } + 1)
            mp.put(t2, mp.getOrElse(t2) { 0 } + 1)
        }
        return mp.values.max() ?: 0
    }
}

fun main() {
    println(Solution().maxEqualRowsAfterFlips(arrayOf(
            intArrayOf(1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1),
            intArrayOf(1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1),
            intArrayOf(1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0),
            intArrayOf(1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1)
    )))
}