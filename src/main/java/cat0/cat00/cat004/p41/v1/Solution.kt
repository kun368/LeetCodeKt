package cat0.cat00.cat004.p41.v1

/**
 * O(1)空间复杂度
 * O(N)时间复杂度
 */
class Solution {

    private val MAX = Int.MAX_VALUE
    private val MIN = Int.MIN_VALUE

    fun firstMissingPositive(nums: IntArray): Int {
        nums.forEachIndexed { idx, it ->
            if (it == MAX) nums[idx] = MAX - 1
            else if (it == MIN) nums[idx] = MIN + 1
        }
        fun fuck(idx: Int) {
            val cur = nums[idx]
            if (cur == MIN || cur == MAX) {
                return
            }
            nums[idx] = MIN
            if (cur < 1 || cur > nums.size) {
                return
            }
            fuck(cur - 1)
            nums[cur - 1] = MAX
        }
        nums.indices.forEach { fuck(it) }
        nums.forEachIndexed { index, it -> if (it == MIN) return index + 1 }
        return nums.size + 1
    }
}

fun main(args: Array<String>) {
    println(Solution().firstMissingPositive(intArrayOf(1, 2, 0)))
    println(Solution().firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    println(Solution().firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
    println(Solution().firstMissingPositive(intArrayOf(2, 1)))
    println(Solution().firstMissingPositive(intArrayOf(2147483647)))
}