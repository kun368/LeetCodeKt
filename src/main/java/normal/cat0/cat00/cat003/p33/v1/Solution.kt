package normal.cat0.cat00.cat003.p33.v1

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var L = 0
        var R = nums.size
        while (R - L > 1) {
            val mid = (L + R) / 2
            if (nums[mid - 1] >= nums[L]) {
                if (target >= nums[L] && target <= nums[mid - 1]) R = mid else L = mid
            } else {
                if (target >= nums[mid] && target <= nums[R - 1]) L = mid else R = mid
            }
        }
        return if (nums.getOrNull(L) == target) L else -1
    }
}

fun main(args: Array<String>) {
    val arr = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    for (i in arr) {
        println(Solution().search(arr, i))
    }
    println(Solution().search(arr, -1))
    println(Solution().search(arr, 3))
    println(Solution().search(arr, 100))
    println(Solution().search(intArrayOf(10), 10))
    println(Solution().search(intArrayOf(10), 9))
    println(Solution().search(intArrayOf(10), 11))
    println(Solution().search(intArrayOf(), 11))
    println(Solution().search(intArrayOf(2, 4, 7, 9, 0), 9))
}