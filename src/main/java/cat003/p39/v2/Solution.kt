package cat003.p39.v2

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val arr = candidates.sorted()
        val ret = arrayListOf<List<Int>>()

        fun solve(st: Int, target: Int, has: List<Int>) {
            if (target == 0) {
                ret += has
            }
            if (st >= arr.size || arr[st] > target) {
                return
            }
            var count = 0
            var cur = has.toList()
            while (count * arr[st] <= target) {
                solve(st + 1, target - count * arr[st], cur)
                count += 1
                cur += arr[st]
            }
        }
        solve(0, target, emptyList())
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(Solution().combinationSum(intArrayOf(2, 3, 5), 8))
}