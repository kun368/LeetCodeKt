package normal.cat0.cat00.cat004.p42.v1

/**
 * 从最高点往下开始判断，累加每一层可以加的水
 * 时间复杂度 O(logN)
 */
class Solution {
    fun trap(height: IntArray): Int {
        val arr = height.withIndex().sortedByDescending { it.value }
        val has = sortedSetOf<Int>()
        var sum = 0
        for (i in arr.indices) {
            has.add(arr[i].index)
            if (i + 1 >= arr.size || arr[i + 1] != arr[i]) {
                val diff = arr[i].value - if (i + 1 >= arr.size) 0 else arr[i + 1].value
                val count = (has.last() - has.first() + 1) - has.size
                sum += diff * count
            }
        }
        return sum
    }
}

fun main() {
    println(Solution().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(Solution().trap(intArrayOf(3, 2, 3)))
}