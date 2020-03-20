package normal.cat0.cat02.cat020.p207.v1

import java.util.*

/**
 * 课程表
 * 拓扑排序
 */
class Solution {
    fun canFinish(n: Int, req: Array<IntArray>): Boolean {
        val cnt = IntArray(n) { 0 }
        val G = Array(n) { arrayListOf<Int>() }
        val qu = LinkedList<Int>()
        var cant = n

        req.forEach {
            ++cnt[it[0]];
            G[it[1]].add(it[0])
        }
        cnt.forEachIndexed { idx, i ->
            if (i == 0) qu.add(idx)
        }
        while (qu.isNotEmpty()) {
            val top = qu.pollFirst()!!
            G[top].forEach { if (--cnt[it] == 0) qu.addLast(it); }
            cnt[top] = -1
            cant -= 1
        }
        return cant == 0
    }
}

fun main(args: Array<String>) {
    println(Solution().canFinish(2, arrayOf(intArrayOf(1, 0))))
    println(Solution().canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
}