package cat0.cat02.cat021.p217.v2

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean = nums.size != nums.toSet().size
}