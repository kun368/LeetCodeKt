package normal.cat0.cat00.cat004.p46.v1

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val ret = arrayListOf<List<Int>>()
        fun dfs(has: LinkedHashSet<Int>) {
            if (has.size >= nums.size) {
                ret.add(has.toList())
                return
            }
            for (i in nums) {
                if (i !in has) {
                    has.add(i)
                    dfs(has)
                    has.remove(i)
                }
            }
        }
        dfs(LinkedHashSet())
        return ret
    }
}

fun main() {
    println(Solution().permute(intArrayOf(1, 2, 3)))
}