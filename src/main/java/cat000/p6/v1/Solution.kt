package cat000.p6.v1

import java.lang.StringBuilder

class Solution {
    fun convert(s: String, numRows: Int): String {
        val ret = Array(numRows) { StringBuilder() }
        s.forEachIndexed { id, ch ->
            var idx = if (numRows == 1) 0 else id % (numRows * 2 - 2)
            if (idx >= numRows) {
                idx = 2 * numRows - idx - 2
            }
            ret[idx].append(ch)
        }
        return ret.joinToString(separator = "")
    }
}

fun main(args: Array<String>) {
    println(Solution().convert("PAYPALISHIRING", 3))
    println(Solution().convert("PAYPALISHIRING", 4))
    println(Solution().convert("PAYPALISHIRING", 1))
}