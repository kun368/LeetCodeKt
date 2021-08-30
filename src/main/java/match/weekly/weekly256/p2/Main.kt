package match.weekly.weekly256.p2

class Solution {
    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        return nums.sortedWith(compareBy<String>({ it.length }, { it }).reversed())[k - 1]
    }
}

fun main() {
    println(Solution().kthLargestNumber(arrayOf("3", "6", "7", "10"), 4))
    println(Solution().kthLargestNumber(arrayOf("2", "21", "12", "1"), 3))
    println(Solution().kthLargestNumber(arrayOf("0", "0"), 2))
}
