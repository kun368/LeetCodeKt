package normal.cat0.cat00.cat001.p19.v1

import utils.kotlin.ListNode

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }

        fun dfs(cur: ListNode?, pre: ListNode): Int {
            if (cur == null) {
                return 0
            }
            val rank = dfs(cur.next, cur) + 1
            if (rank == n) {
                pre.next = cur.next
            }
            return rank
        }

        val mock = ListNode(-1)
        mock.next = head
        dfs(mock, head)
        return mock.next
    }
}

fun main() {
    println(Solution().removeNthFromEnd(ListNode.parse("1->2->3->4->5"), 2))
}