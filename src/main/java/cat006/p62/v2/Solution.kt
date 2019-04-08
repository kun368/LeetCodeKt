package cat006.p62.v2

class Solution {

    private val dp = hashMapOf<String, Int>()

    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 1 || n == 1) {
            return 1
        }
        val key = "${minOf(m, n)}#${maxOf(m, n)}"
        dp[key] ?.apply { return this }
        val ans = uniquePaths(m - 1, n) + uniquePaths(m, n - 1)
        dp[key] = ans
        return ans
    }
}

fun main(args: Array<String>) {
    println(Solution().uniquePaths(23, 12))
}