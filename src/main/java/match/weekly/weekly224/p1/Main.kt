package match.weekly.weekly224.p1

class Solution {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        return rectangles
                .map { minOf(it[0], it[1]) }
                .groupBy { it }
                .maxBy { it.key }
                .value.size
    }
}