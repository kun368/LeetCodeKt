package normal.cat0.cat04.cat045.p451

class Solution {
    fun frequencySort(s: String) = s.groupBy { it }.mapValues { -it.value.size }.run { s.toList().sortedWith(compareBy(this::get, { it })).joinToString("") }
}

fun main() {
    println(Solution().frequencySort("tree"))
    println(Solution().frequencySort("cccaaa"))
    println(Solution().frequencySort("Aabb"))
}