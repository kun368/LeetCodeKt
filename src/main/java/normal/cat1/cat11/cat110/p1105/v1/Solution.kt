package normal.cat1.cat11.cat110.p1105.v1

class Solution {
    fun gen(maxn: Int): List<Int> {
        val arr = ArrayList<Int>()
        var cnt = 1
        var max = 0
        var rev = false
        while (max < maxn) {
            val span = (max + 1) until (max + 1 + cnt)
            arr.addAll(if (rev) span.reversed().toList() else span.toList())
            rev = !rev
            max = span.last
            cnt *= 2
        }
        return arr
    }

    fun pathInZigZagTree(label: Int): List<Int> {
        val gen = gen(label)
        val ret = ArrayList<Int>()
        var idx = gen.indexOf(label)
        while (true) {
            ret.add(gen[idx])
            if (idx ==0) {
                break
            }
            idx = (idx - 1) / 2
        }
        return ret.reversed()
    }
}

fun main() {
    println(Solution().pathInZigZagTree(14))
    println(Solution().pathInZigZagTree(26))
    println(Solution().pathInZigZagTree(1))
    println(Solution().pathInZigZagTree(1000000))
}