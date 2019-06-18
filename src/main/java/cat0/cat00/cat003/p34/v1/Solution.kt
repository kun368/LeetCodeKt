package cat0.cat00.cat003.p34.v1

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var L = 0
        var R = nums.size
        var ansL = nums.size
        while (L < R) {
            val mid = (L + R) / 2
            if (nums[mid] >= target) {
                ansL = mid
                R = mid
            } else {
                L = mid + 1
            }
        }
        L = ansL
        R = nums.size
        var ansR = nums.size
        while (L < R) {
            val mid = (L + R) / 2
            if (nums[mid] > target) {
                ansR = mid
                R = mid
            } else {
                L = mid + 1
            }
        }
        return if (nums.getOrNull(ansL) == target) intArrayOf(ansL, ansR - 1) else intArrayOf(-1, -1)
    }
}

fun main(args: Array<String>) {
    println(Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).toList())
    println(Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).toList())
}