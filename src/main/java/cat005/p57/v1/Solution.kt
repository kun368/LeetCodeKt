package cat005.p57.v1

import utils.kotlin.Interval


class Solution {
    fun insert(intervals: List<Interval>, newInterval: Interval): List<Interval> {
        val mergeSpanStart = intervals.indexOfFirst { it.end >= newInterval.start }
        val mergeSpanEnd = intervals.indexOfLast { it.start <= newInterval.end }
        if (mergeSpanStart == -1) {
            return intervals.toMutableList().apply { add(newInterval) }
        }
        if (mergeSpanEnd == -1) {
            return arrayListOf(newInterval).apply { addAll(intervals) }
        }

        val addLeft = minOf(intervals[mergeSpanStart].start, newInterval.start)
        val addRight = maxOf(intervals[mergeSpanEnd].end, newInterval.end)
        val ret = arrayListOf<Interval>()
        ret += intervals.subList(0, mergeSpanStart)
        ret += Interval(addLeft, addRight)
        ret += intervals.subList(mergeSpanEnd + 1, intervals.size)
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().insert(arrayListOf(
            Interval(1, 2), Interval(3, 5), Interval(6, 7), Interval(8, 10), Interval(12, 16)
    ), Interval(4, 8)))

    println(Solution().insert(arrayListOf(
            Interval(1, 3), Interval(6, 9)
    ), Interval(2, 5)))

    println(Solution().insert(arrayListOf(
            Interval(1, 3), Interval(6, 9)
    ), Interval(4, 5)))

    println(Solution().insert(arrayListOf(
            Interval(1, 3), Interval(6, 9)
    ), Interval(14, 45)))

    println(Solution().insert(arrayListOf(
            Interval(1, 3), Interval(6, 9)
    ), Interval(-14, -5)))
}