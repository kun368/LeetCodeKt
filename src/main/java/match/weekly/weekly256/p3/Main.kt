package match.weekly.weekly256.p3

class Solution {

    fun minSessions(tasks: IntArray, sessionTime: Int): Int {
        val n = tasks.size
        val maxN = 1.shl(n)

        val canDo = BooleanArray(maxN)
        for (i in 0 until maxN) {
            canDo[i] = (0 until n).filter { i.and(1.shl(it)) > 0 }.map { tasks[it] }.sum() <= sessionTime
        }

        val dp = IntArray(maxN) { it }
        for (i in 1 until maxN) {
            var subset = i
            while (subset > 0) {
                if (canDo[subset]) {
                    dp[i] = minOf(dp[i], dp[i.xor(subset)] + 1)
                }
                subset = (subset - 1).and(i)
            }
        }
        return dp.last()
    }
}

fun main() {
    println(Solution().minSessions(intArrayOf(1, 2, 3), 3))
    println(Solution().minSessions(intArrayOf(3, 1, 3, 1, 1), 6))
    println(Solution().minSessions(intArrayOf(1, 2, 3, 4, 5), 15))
}
