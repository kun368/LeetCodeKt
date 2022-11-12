package normal.cat0.cat00.cat001.p12.v1

import java.util.*

val mp = TreeMap(mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
))

class Solution {
    fun intToRoman(num: Int): String {
        var cur = num
        return buildString {
            while (cur > 0) {
                mp.floorEntry(cur)?.let {
                    cur -= it.key
                    append(it.value)
                }
            }
        }
    }
}

fun main() {
    println(Solution().intToRoman(3))
    println(Solution().intToRoman(4))
    println(Solution().intToRoman(9))
    println(Solution().intToRoman(58))
    println(Solution().intToRoman(1994))
}