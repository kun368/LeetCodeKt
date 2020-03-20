package normal.cat0.cat00.cat002.p22.v1

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val ret = arrayListOf<String>()
        fun dfs(cur: String, left: Int, right: Int) {
            if (left == 0 && right == 0) {
                ret += cur
                return
            }
            if (left > 0) dfs("$cur(", left - 1, right + 1)
            if (right > 0) dfs("$cur)", left, right - 1)
        }
        dfs("", n, 0)
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().generateParenthesis(0))
    println(Solution().generateParenthesis(1))
    println(Solution().generateParenthesis(3))
}