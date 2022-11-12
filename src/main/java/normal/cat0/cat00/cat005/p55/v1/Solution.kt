package normal.cat0.cat00.cat005.p55.v1

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var max = 0
        return nums.mapIndexed { idx, it ->
            if (idx <= max) {
                max = maxOf(max, idx + it); true
            } else false
        }.last()
    }
}

fun main() {
    println(Solution().canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(Solution().canJump(intArrayOf(3, 2, 1, 0, 4)))
}