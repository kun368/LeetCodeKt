package cat0.cat00.cat002.p23.v1

import utils.kotlin.ListNode
import java.util.*

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val bestMap = TreeMap(lists
                .filterNotNull()
                .groupBy { it.`val` }
                .mapValues { it -> it.value.toMutableList() }
        )
        val head = ListNode(-1)
        var cur = head
        while (bestMap.isNotEmpty()) {
            val best = bestMap.pollFirstEntry()
            best.value.forEach {
                cur.next = ListNode(best.key)
                cur = cur.next!!
                val next = it.next
                if (next != null) {
                    bestMap.getOrPut(next.`val`) { arrayListOf() } += next
                }
            }
        }
        return head.next
    }
}

fun main(args: Array<String>) {
    println(Solution().mergeKLists(arrayOf(
            ListNode.parse("1->4->5"),
            ListNode.parse("1->3->4"),
            ListNode.parse("2->6")
    )))
}