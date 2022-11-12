package normal.cat0.cat00.cat002.p25.v1

import utils.kotlin.ListNode


class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val mock = ListNode(-1)
        mock.next = head

        fun dfs(head: ListNode) {
            val list = arrayListOf<ListNode>()
            var cur = head.next
            for (i in 0 until k) {
                if (cur == null) {
                    return
                }
                list.add(cur)
                cur = cur.next
            }
            for (i in 1..list.lastIndex) {
                list[i].next = list[i - 1]
            }
            list.first().next = cur
            head.next = list.last()
            dfs(list.first())
        }

        dfs(mock)
        return mock.next
    }
}

fun main() {
    println(Solution().reverseKGroup(ListNode.parse("1->2->3->4->5"), 1))
    println(Solution().reverseKGroup(ListNode.parse("1->2->3->4->5"), 2))
    println(Solution().reverseKGroup(ListNode.parse("1->2->3->4->5"), 3))
}