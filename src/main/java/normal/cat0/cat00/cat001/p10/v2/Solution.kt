package normal.cat0.cat00.cat001.p10.v2

/**
 * 动态规划版
 */
class Solution {

    fun isMatch(s: String, p: String): Boolean {
        val dp = Array(s.length + 1) {
            arrayOfNulls<Boolean>(p.length + 1)
        }

        fun String.padGet(idx: Int) = if (idx == 0) '$' else this[idx - 1]

        fun singleMatch(i: Int, j: Int): Boolean {
            val sCur = s.padGet(i)
            val pCur = p.padGet(j)
            return when {
                sCur == pCur -> true
                pCur == '.' -> true
                else -> false
            }
        }

        fun solve(i: Int, j: Int): Boolean {
            when {
                i < 0 || i > s.length || j < 0 || j > p.length -> return false
                i == 0 && j == 0 -> return true
            }
            dp[i][j]?.let { return it }
            return when {
                singleMatch(i, j) && solve(i - 1, j - 1) -> true
                p.padGet(j) == '*' && singleMatch(i, j - 1) && solve(i - 1, j) -> true
                p.padGet(j) == '*' && solve(i, j - 1) -> true
                p.padGet(j) == '*' && solve(i, j - 2) -> true
                else -> false
            }.apply {
                dp[i][j] = this
            }
        }

        return solve(s.length, p.length)
    }
}

fun main() {
    println(Solution().isMatch("aa", "a"))
    println(Solution().isMatch("aa", "a*"))
    println(Solution().isMatch("ab", ".*"))
    println(Solution().isMatch("mississippi", "mis*is*p*."))
    println(Solution().isMatch("aab", "c*a*b"))
    println(Solution().isMatch("aaa", "ab*a*c*a"))
    println(Solution().isMatch("aaa", ".*"))
}