package normal.cat0.cat00.cat006.p68.v1

class Solution {

    private fun avgJoin(arr: List<String>, maxWidth: Int): String {
        if (arr.size <= 1) {
            return leftJoin(arr, maxWidth)
        }
        val remain = maxWidth - arr.sumOf { it.length }
        val space = remain / (arr.size - 1)
        val addOne = remain % (arr.size - 1)
        val sb = StringBuffer()
        for (i in arr.indices) {
            sb.append(arr[i])
            if (i == 0 || i != arr.lastIndex) {
                sb.append(Array(space + if (i < addOne) 1 else 0) { ' ' }.joinToString(separator = ""))
            }
        }
        return sb.toString()
    }

    private fun leftJoin(arr: List<String>, maxWidth: Int): String {
        val last = StringBuffer(arr.joinToString(separator = " "))
        while (last.length < maxWidth) {
            last.append(' ')
        }
        return last.toString()
    }

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val ret = arrayListOf<String>()
        val curArr = arrayListOf<String>()
        var curLen = 0
        for (word in words) {
            if (curLen + word.length + curArr.size > maxWidth) {
                ret += avgJoin(curArr, maxWidth)
                curArr.clear()
                curLen = 0
            }
            curArr += word
            curLen += word.length
        }
        if (curArr.isNotEmpty()) { ret += leftJoin(curArr, maxWidth) }
        return ret
    }
}

fun main() {
    println(Solution().fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16))
    println(Solution().fullJustify(arrayOf("What", "must", "be", "acknowledgment", "shall", "be"), 16))
    println(Solution().fullJustify(arrayOf("Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
            "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"), 20))
}