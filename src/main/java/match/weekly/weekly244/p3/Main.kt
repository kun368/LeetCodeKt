package match.weekly.weekly244.p3

class Solution {

    fun check(s: String, b: Int): Int {
        var ret = 0
        for (i in s.indices) {
            val need = if ((b + i) % 2 == 0) '0' else '1'
            if (need != s[i]) {
                ret += 1
            }
        }
        // println("s = $s, b = $b, ret = $ret")

        var best = ret
        for (i in s.indices) {
            val preNeed = if ((b + i) % 2 == 0) '0' else '1'
            val curNeed = if ((b + i + s.length) % 2 == 0) '0' else '1'
            if (curNeed != preNeed){
                if (curNeed == s[i]) ret -= 1
                else ret += 1
            }
            best = minOf(ret, best)
        }
        return best
    }

    fun minFlips(s: String): Int {
        return minOf(check(s, 0), check(s, 1))
    }
}

fun main() {
    println(Solution().minFlips("111000"))
    println(Solution().minFlips("010"))
    println(Solution().minFlips("1110"))
    println(Solution().minFlips("10001100101000000"))
}
