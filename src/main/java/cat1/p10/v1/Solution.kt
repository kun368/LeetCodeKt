package cat1.p10.v1

class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return s.matches(p.toRegex())
    }
}