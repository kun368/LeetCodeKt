package normal.cat0.cat00.cat001.p11.v2

/**
 * O(N)双指针法
 * 考虑最优解一定在指针移动的这个区间，或者两个区间内都有
 */
class Solution {
    fun maxArea(h: IntArray): Int {
        var maxSize = 0
        var i = 0
        var j = h.lastIndex
        while (i < j) {
            maxSize = maxOf(maxSize, (j - i) * minOf(h[i], h[j]))
            if (h[i] < h[j]) ++i else --j
        }
        return maxSize
    }
}

fun main(args: Array<String>) {
    println(Solution().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}