package match.weekly.weekly244.p4
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList

private fun <T> MutableList<T>.popLast() = this.removeAt(size - 1)

class Solution {

    val mod: Long = 1000000007
    val maxBox = 100005

    fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {
        packages.sort()
        val okBoxes = arrayListOf<MutableList<Int>>()
        for (i in boxes.indices) {
            boxes[i].sort()
            if (boxes[i].last() >= packages.last()) {
                val t = boxes[i].toMutableList()
                t.add(maxBox)
                okBoxes.add(t)
            }
        }
        val idxMap = TreeMap<Int, ArrayList<Int>>()
        for (i in okBoxes.indices) {
            for (j in okBoxes[i]) {
                idxMap.getOrPut(j) { ArrayList() }.add(i)
            }
        }
        val idxList = idxMap.toList().reversed()

        var tsum = BigInteger.ZERO
        packages.forEach { tsum += maxBox.toBigInteger() - it.toBigInteger() }
        val ans = Array(okBoxes.size) { tsum }
        if (ans.isEmpty()) return -1

        val remains = packages.toMutableList()
        for (i in idxList) {
            if (i.first >= maxBox) continue
            while (remains.isNotEmpty() && remains.last() > i.first) {
                remains.popLast()
            }
            if (remains.isEmpty()) break
            for (j in i.second) {
                val save = remains.size.toLong() * (okBoxes[j].popLast() - i.first)
                ans[j] -= save.toBigInteger()
            }
        }
        return ans.min()!!.mod(mod.toBigInteger()).toInt()
    }
}

fun main(args: Array<String>) {
    println(
        Solution().minWastedSpace(
            intArrayOf(2, 3, 5),
            arrayOf(
                intArrayOf(4, 8),
                intArrayOf(2, 8)
            )
        )
    )
    println(
        Solution().minWastedSpace(
            intArrayOf(2, 3, 5),
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 3),
                intArrayOf(3, 4)
            )
        )
    )
    println(
        Solution().minWastedSpace(
            intArrayOf(3, 5, 8, 10, 11, 12),
            arrayOf(
                intArrayOf(12),
                intArrayOf(11, 9),
                intArrayOf(10, 5, 14)
            )
        )
    )
}
