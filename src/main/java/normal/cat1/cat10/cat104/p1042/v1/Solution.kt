package normal.cat1.cat10.cat104.p1042.v1

/**
 * 不邻接植花
 */
class Solution {
    fun gardenNoAdj(N: Int, paths: Array<IntArray>): IntArray {
        val g = Array(N) { ArrayList<Int>() }
        for (path in paths) {
            g[path[0] - 1].add(path[1] - 1)
            g[path[1] - 1].add(path[0] - 1)
        }
        val ret = IntArray(N) { -1 }
        for (i in 0 until N) {
            val has = g[i].map { ret[it] }
            for (j in 1..4) {
                if (j in has) continue
                ret[i] = j
                break
            }
        }
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().gardenNoAdj(3, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
    )).toList())
    println(Solution().gardenNoAdj(4, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
    )).toList())
    println(Solution().gardenNoAdj(4, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 1),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
    )).toList())
}