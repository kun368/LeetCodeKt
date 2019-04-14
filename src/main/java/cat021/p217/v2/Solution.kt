package cat021.p217.v2

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean = nums.size != nums.toSet().size
}