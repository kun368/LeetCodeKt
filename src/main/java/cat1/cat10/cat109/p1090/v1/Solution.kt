package cat1.cat10.cat109.p1090.v1

class Solution {
    fun largestValsFromLabels(v: IntArray, labels: IntArray, num_wanted: Int, use_limit: Int): Int {
        val zip = v.zip(labels).sortedByDescending { it.first }
        val cnt = HashMap<Int, Int>()
        var ret = 0
        var tot = 0
        for (it in zip) {
            if (cnt.getOrPut(it.second) { 0 } >= use_limit)
                continue
            ret += it.first
            cnt.put(it.second, cnt.get(it.second)!! + 1)
            if (++tot >= num_wanted)
                break
        }
        return ret
    }
}

fun main() {
    println(Solution().largestValsFromLabels(
            intArrayOf(5, 4, 3, 2, 1),
            intArrayOf(1, 1, 2, 2, 3),
            3, 1
    ))
}