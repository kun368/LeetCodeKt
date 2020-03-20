package normal.cat1.cat10.cat102.p1030.v1

import kotlin.math.abs

class Solution {
    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> = (0 until R).flatMap { a -> (0 until C).map { b -> intArrayOf(a, b) } } .sortedBy { abs(it[0] - r0) + abs(it[1] - c0) } .toTypedArray()
}

fun main() {
    println(Solution().allCellsDistOrder(1, 2, 0, 0).map { it.toList() }.toList())
    println(Solution().allCellsDistOrder(2, 2, 0, 1).map { it.toList() }.toList())
    println(Solution().allCellsDistOrder(2, 3, 1, 2).map { it.toList() }.toList())
}