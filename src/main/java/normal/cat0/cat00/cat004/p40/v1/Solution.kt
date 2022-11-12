package normal.cat0.cat00.cat004.p40.v1

class Solution {
    fun combinationSum2(arr: IntArray, target: Int): List<List<Int>> {
        val ret = hashSetOf<List<Int>>()
        arr.sort()

        fun dfs(st: Int, target: Int, has: List<Int>) {
            if (target == 0) {
                ret += has
                return
            }
            if (st >= arr.size || arr[st] > target) {
                return
            }
            dfs(st + 1, target, has)
            val cur = ArrayList(has)
            cur.add(arr[st])
            dfs(st + 1, target - arr[st], cur)
        }

        dfs(0, target, emptyList())
        return ret.toList()
    }
}

fun main() {
    println(Solution().combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    println(Solution().combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
}