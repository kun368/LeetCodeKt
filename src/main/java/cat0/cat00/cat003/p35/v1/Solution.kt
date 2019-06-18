package cat0.cat00.cat003.p35.v1

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var L = 0
        var R = nums.size
        var ok = nums.size
        while (L < R) {
            val mid = (L + R) shr 1
            if (nums[mid] >= target) {
                ok = mid
                R = mid
            } else {
                L = mid + 1
            }
        }
        return ok
    }
}

fun main(args: Array<String>) {
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 7))
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 0))
}