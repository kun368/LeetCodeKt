package normal.cat1.cat10.cat109.p1091.v1

import java.util.*
import kotlin.collections.HashSet

class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val N = grid.size
        val vis = HashSet<String>()

        fun can(x: Int, y: Int): Boolean {
            return x >= 0 && x < N && y >= 0 && y < N && grid[x][y] == 0 && !vis.contains("$x#$y")
        }

        if (!can(0, 0)) return -1
        val qu = LinkedList<Triple<Int, Int, Int>>()
        qu.offer(Triple(0, 0, 1))
        vis += "0#0"

        while (!qu.isEmpty()) {
            val pop = qu.poll()
            if (pop.first == N - 1 && pop.second == N - 1) {
                return pop.third
            }
            for (dx in arrayOf(-1, 0, 1)) {
                for (dy in arrayOf(-1, 0, 1)) {
                    val x = pop.first + dx
                    val y = pop.second + dy
                    val key = "$x#$y"
                    if (can(x, y)) {
                        qu.offer(Triple(x, y, pop.third + 1))
                        vis += key
                    }
                }
            }
        }
        return -1
    }
}

fun main() {
//    println(Solution().shortestPathBinaryMatrix(arrayOf(
//            intArrayOf(0, 1),
//            intArrayOf(1, 0)
//    )))
//    println(Solution().shortestPathBinaryMatrix(arrayOf(
//            intArrayOf(0, 0, 0),
//            intArrayOf(1, 1, 0),
//            intArrayOf(1, 1, 0)
//    )))
//    println(Solution().shortestPathBinaryMatrix(arrayOf(
//            intArrayOf(1, 0, 0),
//            intArrayOf(1, 1, 0),
//            intArrayOf(1, 1, 0)
//    )))
    println(Solution().shortestPathBinaryMatrix(arrayOf(
            intArrayOf(0, 1, 0, 0, 0, 0),
            intArrayOf(0, 1, 1, 1, 1, 1),
            intArrayOf(0, 0, 0, 0, 1, 1),
            intArrayOf(0, 1, 0, 0, 0, 1),
            intArrayOf(1, 0, 0, 1, 0, 1),
            intArrayOf(0, 0, 1, 0, 1, 0)
    )))
}