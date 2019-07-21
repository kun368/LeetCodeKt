package match.weekly146.p1

class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        return dominoes.map { it.sorted() }.groupBy { it }.mapValues { it.value.size }.values.map { (it * (it - 1)) / 2 }.sum()
    }
}

fun main(args: Array<String>) {
    println(Solution().numEquivDominoPairs(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
    )))
}