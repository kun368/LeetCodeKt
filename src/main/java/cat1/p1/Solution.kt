package cat1.p1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, i ->
            val prev = map[target - i]
            if (prev != null) {
                return intArrayOf(prev, index)
            }
            map[i] = index
        }
        return intArrayOf()
    }
}

fun main(args: Array<String>) {
    val test = Solution()
//    val ret = test.twoSum(intArrayOf(2, 7, 11, 15), 9)
    val ret = test.twoSum(intArrayOf(3, 2, 4), 6)
    print(ret.toList())
}
