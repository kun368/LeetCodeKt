package match.weekly.weekly256.p4

class Solution {
    fun numberOfUniqueGoodSubsequences(binary: String): Int {
        var dp0 = 0
        var dp1 = 0
        var has0 = 0
        val mod: Int = (1e9 + 7).toInt()

        for (i in binary.indices.reversed()) {
            if (binary[i] == '0') {
                has0 = 1
                dp0 = (dp0 + dp1 + 1) % mod
            } else {
                dp1 = (dp0 + dp1 + 1) % mod
            }
        }
        return (dp1 + has0) % mod
    }
}

fun main() {
    println(Solution().numberOfUniqueGoodSubsequences("001"))
    println(Solution().numberOfUniqueGoodSubsequences("11"))
    println(Solution().numberOfUniqueGoodSubsequences("101"))
}
