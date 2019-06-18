package cat0.cat00.cat006.p61.v1

import utils.kotlin.ListNode

class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 0) {
            return head
        }
        val mock = ListNode(-1)
        mock.next = head
        var totalCount = 0

        fun dfs(pre: ListNode, cur: ListNode?, has: Int): Int {
            if (cur == null) {
                if (k % has != 0) {
                    pre.next = mock.next
                }
                totalCount = has
                return 0
            }
            val dep = dfs(cur, cur.next, has + 1) + 1
            if (dep == k % totalCount) {
                pre.next = null
                mock.next = cur
            }
            return dep
        }
        dfs(mock, mock.next, 0)
        return mock.next
    }
}


fun main(args: Array<String>) {
    println(Solution().rotateRight(ListNode.parse("1->2->3->4->5"), 0))
    println(Solution().rotateRight(ListNode.parse("0->1->2"), 4))
    println(Solution().rotateRight(ListNode.parse("1"), 1))
}