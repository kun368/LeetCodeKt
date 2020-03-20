package normal.cat1.cat11.cat110.p1104.v1


class Solution {
    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        val ret = Array(num_people) { 0 }
        var rem = candies
        var cur = 1
        var idx = 0
        while (rem > 0) {
            val add = minOf(rem, cur)
            ret[idx] += add
            cur += 1
            rem -= add
            idx = (idx + 1) % num_people
        }
        return ret.toIntArray()
    }
}

fun main() {
    println(Solution().distributeCandies(7, 4).toList())
    println(Solution().distributeCandies(10, 3).toList())
}