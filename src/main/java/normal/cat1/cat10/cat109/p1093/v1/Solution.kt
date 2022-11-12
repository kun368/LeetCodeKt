package normal.cat1.cat10.cat109.p1093.v1

class Solution {
    fun sampleStats(v: IntArray): DoubleArray {
        val tot = v.sum()
        var min = 255
        var max = 0
        var sum = 0.0
        var precnt = 0
        var zws = 0.0
        for (i in v.indices) {
            val cnt = v[i]
            if (cnt > 0) {
                min = minOf(min, i)
                max = maxOf(max, i)
                sum += cnt * 1.0 * i
            }
            val span = IntRange(precnt, precnt + cnt - 1)
            if (tot % 2 == 0) {
                if (tot / 2 in span) {
                    zws += i
                }
                if ((tot / 2) - 1 in span) {
                    zws += i
                }
            } else {
                if (tot / 2 in span) {
                    zws += i + i
                }
            }
            precnt += cnt
        }
        zws /= 2
        val zhongshu = v.withIndex().maxBy { it.value }.index

        return doubleArrayOf(min.toDouble(), max.toDouble(), sum * 1.0 / tot, zws, zhongshu.toDouble())
    }
}

fun main() {
    println(4 in IntRange(1, 4))
    println(Solution().sampleStats(intArrayOf(0, 1, 3, 4, 0, 0)).toList())
    println(Solution().sampleStats(intArrayOf(0, 4, 3, 2, 2, 0, 0, 0, 0, 0)).toList())
}