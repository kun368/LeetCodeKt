package normal.cat1.cat10.cat107.p1078.v1

import java.util.*

class Solution {
    fun smallestSubsequence(text: String): String {
        val remain = TreeSet(text.toSet().sorted())
        val ret = arrayListOf<Char>()
        var t = text
        while (remain.isNotEmpty()) {
            for (c in remain) {
                val right = c + t.substringAfter(c)
                val ok = remain.all { right.contains(it) }
                if (ok) {
                    ret.add(c)
                    t = right.substring(1)
                    remain.remove(c)
                    break
                }
            }
        }
        return ret.joinToString(separator = "")
    }
}

fun main() {
    println(Solution().smallestSubsequence("cdadabcc"))
    println(Solution().smallestSubsequence("abcd"))
    println(Solution().smallestSubsequence("ecbacba"))
    println(Solution().smallestSubsequence("leetcode"))
}