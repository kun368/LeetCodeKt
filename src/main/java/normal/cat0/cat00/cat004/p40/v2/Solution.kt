package normal.cat0.cat00.cat004.p40.v2

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun combinationSum2(arr: IntArray, target: Int): List<List<Int>> {
        val ret = arrayListOf<List<Int>>()
        val counter = TreeMap<Int, Int>()
                .apply { arr.forEach { this[it] = this.getOrDefault(it, 0) + 1 } }
                .toList()

        fun dfs(idx: Int, target: Int, has: List<Int>) {
            if (target == 0) {
                ret += ArrayList(has)
                return
            }
            if (idx >= counter.size || counter[idx].first > target) {
                return
            }
            val cur = ArrayList(has)
            for (i in 0..counter[idx].second) {
                val remain = target - i * counter[idx].first
                if (remain < 0) {
                    break
                }
                dfs(idx + 1, remain, cur)
                cur.add(counter[idx].first)
            }
        }

        dfs(0, target, emptyList())
        return ret
    }
}

fun main() {
    println(Solution().combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    println(Solution().combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
}