package match.weekly.weekly224.p2

class Solution {
    fun tupleSameProduct(nums: IntArray): Int {
        val cnt = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val s = nums[i] * nums[j]
                cnt[s] = cnt.getOrDefault(s, 0) + 1
            }
        }
        println(cnt)
        var ret = 0
        for (i in cnt.values) {
            ret += i * (i - 1) * 4
        }
        return ret
    }
}

fun main(args: Array<String>) {
    Solution().tupleSameProduct(intArrayOf(2, 3, 4, 6))
    Solution().tupleSameProduct(intArrayOf(1, 2, 4, 5, 10))
    Solution().tupleSameProduct(intArrayOf(2, 3, 4, 6, 8, 12))
    Solution().tupleSameProduct(intArrayOf(2, 3, 5, 7))
}