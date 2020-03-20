package normal.cat0.cat00.cat001.p17.v1

class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) {
            return emptyList()
        }
        val mp = mapOf(
                '1' to listOf(""),
                '2' to listOf("a", "b", "c"),
                '3' to listOf("d", "e", "f"),
                '4' to listOf("g", "h", "i"),
                '5' to listOf("j", "k", "l"),
                '6' to listOf("m", "n", "o"),
                '7' to listOf("p", "q", "r", "s"),
                '8' to listOf("t", "u", "v"),
                '9' to listOf("w", "x", "y", "z")
        )
        val ret = arrayListOf<String>()

        fun dfs(idx: Int, cur: String) {
            if (idx >= digits.length) {
                ret += cur
                return
            }
            mp[digits[idx]]?.forEach {
                dfs(idx + 1, cur + it)
            }
        }

        dfs(0, "")
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().letterCombinations("23"))
}