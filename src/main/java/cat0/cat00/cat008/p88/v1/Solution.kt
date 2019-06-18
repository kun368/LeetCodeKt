package cat0.cat00.cat008.p88.v1

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var mm = m - 1
        var nn = n - 1
        var i = nums1.lastIndex
        while (mm >= 0 || nn >= 0) {
            if (nn < 0 || (mm >= 0 && nums1[mm] > nums2[nn])) {
                nums1[i--] = nums1[mm--]
            } else {
                nums1[i--] = nums2[nn--]
            }
        }
    }
}

fun main(args: Array<String>) {
    val arr = intArrayOf(1, 2, 3, 0, 0, 0)
    Solution().merge(arr, 3, intArrayOf(2, 5, 6), 3)
    println(arr.toList())
}