package cat0.cat07.cat073.p738.v1

import java.util.*

//
// LeetCode 739. 每日温度
//
// 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
//
class Solution {
    fun dailyTemperatures(T: IntArray): IntArray {
        val ret = IntArray(T.size) { 0 }
        val has = TreeSet<Int>()
        T.withIndex().sortedByDescending { it.value }.forEach {
            has.higher(it.index)?.let { higher ->
                ret[it.index] = higher - it.index
            }
            has += it.index
        }
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).toList())
}