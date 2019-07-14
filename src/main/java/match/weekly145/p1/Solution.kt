package match.weekly145.p1

class Solution {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val map = arr2.withIndex().associate { it -> it.value to it.index }
        return arr1.sortedBy { map[it] ?: it+5000 }.toIntArray()
    }
}

fun main(args: Array<String>) {
    println(Solution().relativeSortArray(
            intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19),
            intArrayOf(2, 1, 4, 3, 9, 6)
    ).toList())
}