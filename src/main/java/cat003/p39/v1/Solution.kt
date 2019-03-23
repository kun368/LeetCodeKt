package cat003.p39.v1

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val arr = candidates.toSortedSet().toList()
        val dp = hashMapOf<String, List<List<Pair<Int, Int>>>>()

        fun solve(st: Int, target: Int): List<List<Pair<Int, Int>>> {
            if (target == 0) {
                return arrayListOf(emptyList())
            }
            if (st >= arr.size || arr[st] > target) {
                return emptyList()
            }
            val key = "$st-$target"
            dp[key]?.run { return this }
            var count = 0
            val curResult = arrayListOf<List<Pair<Int, Int>>>()
            while (count * arr[st] <= target) {
                val next = solve(st + 1, target - count * arr[st])
                for (n in next) {
                    val tmp = arrayListOf(count to arr[st])
                    tmp.addAll(n)
                    curResult.add(tmp)
                }
                count += 1
            }
            dp[key] = curResult
            return curResult
        }

        val ret = arrayListOf<List<Int>>()
        for (i: List<Pair<Int, Int>> in solve(0, target)) {
            val cur = arrayListOf<Int>()
            for (pair in i) {
                (0 until pair.first).forEach { _ -> cur += pair.second }
            }
            ret.add(cur)
        }
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(Solution().combinationSum(intArrayOf(2, 3, 5), 8))
}