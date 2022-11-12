package normal.cat0.cat00.cat003.p38.v1

class Solution {
    fun countAndSay(n: Int): String {
        var cur = "1"
        for (i in 1 until n) {
            val tmp = buildString {
                for (j in cur.indices) {
                    if (j > 0 && cur[j] != cur[j - 1]) {
                        append(",")
                    }
                    append(cur[j])
                }
            }
            cur = tmp.split(',').joinToString(separator = "") { "${it.length}${it.first()}" }
        }
        return cur
    }
}

fun main() {
    for (i in 1..30) {
        println(Solution().countAndSay(i))
    }
}