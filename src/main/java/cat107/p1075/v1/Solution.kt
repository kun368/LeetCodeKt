package cat107.p1075.v1

class Solution {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val split = text.split(" ")
        val ret = ArrayList<String>()
        for (i in 0 until split.size - 2) {
            if (split[i] == first && split[i + 1] == second) {
                ret += split[i + 2]
            }
        }
        return ret.toTypedArray()
    }
}

fun main() {
    println(Solution().findOcurrences("alice is a good girl she is a good student", "a", "good").toList())
    println(Solution().findOcurrences("we will we will rock you", "we", "will").toList())
}