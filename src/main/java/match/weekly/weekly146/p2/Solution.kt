package match.weekly.weekly146.p2

class Solution {
    fun shortestAlternatingPaths(n: Int, red_edges: Array<IntArray>, blue_edges: Array<IntArray>): IntArray {
        val ans0 = IntArray(n) { Int.MAX_VALUE / 2 }
        val ans1 = IntArray(n) { Int.MAX_VALUE / 2 }
        val g0 = red_edges.groupBy { it[0] }.mapValues { it.value.map { a -> a[1] } }
        val g1 = blue_edges.groupBy { it[0] }.mapValues { it.value.map { a -> a[1] } }

        fun dfs(cur: Int, len: Int, type: Int) {
            if (type == 0) {
                if (ans0[cur] <= len) {
                    return
                }
                ans0[cur] = len
                g0[cur]?.forEach { dfs(it, len + 1, 1 - type) }
            } else {
                if (ans1[cur] <= len) {
                    return
                }
                ans1[cur] = len
                g1[cur]?.forEach { dfs(it, len + 1, 1 - type) }
            }
        }
        dfs(0, 0, 0)
        dfs(0, 0, 1)
        return ans0.zip(ans1)
                .map { minOf(it.first, it.second) }
                .map { if (it >= Int.MAX_VALUE / 2) -1 else it }.toIntArray()
    }
}

fun main() {
    println(Solution().shortestAlternatingPaths(
            3,
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)),
            arrayOf()
    ).toList())

    println(Solution().shortestAlternatingPaths(
            3,
            arrayOf(intArrayOf(0, 1)),
            arrayOf(intArrayOf(2, 1))
    ).toList())

    println(Solution().shortestAlternatingPaths(
            3,
            arrayOf(intArrayOf(1, 0)),
            arrayOf(intArrayOf(2, 1))
    ).toList())

    println(Solution().shortestAlternatingPaths(
            3,
            arrayOf(intArrayOf(0, 1)),
            arrayOf(intArrayOf(1, 2))
    ).toList())

    println(Solution().shortestAlternatingPaths(
            3,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)),
            arrayOf(intArrayOf(1, 0))
    ).toList())

    println(Solution().shortestAlternatingPaths(
            5,
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4)),
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))
    ).toList())
}