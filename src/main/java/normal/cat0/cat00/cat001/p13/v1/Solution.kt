package normal.cat0.cat00.cat001.p13.v1

class Solution {
    fun romanToInt(s: String): Int {
        val mp = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var sum = 0
        var pre = Int.MAX_VALUE
        s.map { mp[it] ?: 0 } .forEachIndexed { _, cur ->
            sum += cur + if (pre < cur) -2 * pre else 0
            pre = cur
        }
        return sum
    }
}

fun main() {
    println(Solution().romanToInt("III"))
    println(Solution().romanToInt("IV"))
    println(Solution().romanToInt("IX"))
    println(Solution().romanToInt("LVIII"))
    println(Solution().romanToInt("MCMXCIV"))
}