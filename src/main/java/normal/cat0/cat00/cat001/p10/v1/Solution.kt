package normal.cat0.cat00.cat001.p10.v1

class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return s.matches(p.toRegex())
    }
}