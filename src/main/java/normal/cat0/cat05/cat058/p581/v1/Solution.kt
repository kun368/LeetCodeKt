package normal.cat0.cat05.cat058.p581.v1

class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        if (nums.size <= 1) return 0
        val t = nums.sorted()
        var l = nums.lastIndex
        var r = 0
        for (i in nums.indices) if (nums[i] != t[i]) { l = i; break; }
        for (i in nums.indices.reversed()) if (nums[i] != t[i]) { r = i; break; }
        return if (r >= l) r - l + 1 else 0
    }
}

fun main() {
    println(Solution().findUnsortedSubarray(intArrayOf(2, 6, 4, 8, 10, 9, 15)))
    println(Solution().findUnsortedSubarray(intArrayOf(2, 6, 4, 8, 10, 9, 15).sortedArray()))
    println(Solution().findUnsortedSubarray(intArrayOf()))
    println(Solution().findUnsortedSubarray(intArrayOf(1)))
}