package normal.cat0.cat00.cat004.p49.v1

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { it.toCharArray().sorted() }.values.toList()
    }
}

fun main() {
    println(Solution().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}