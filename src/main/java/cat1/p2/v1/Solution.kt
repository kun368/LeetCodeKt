package cat1.p2.v1

import cat1.p2.v2.ListNode
import cat1.p2.v2.Solution

class ListNode(var `val`: Int, var next: ListNode? = null) {
    override fun toString(): String {
        return "ListNode(`val`=$`val`, next=$next)"
    }
}

class Solution {
    fun toBig(l1: ListNode?) =
            buildString {
                var t = l1
                while (t != null) {
                    append(t.`val`)
                    t = t.next
                }
            }.reversed().toBigInteger()

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var cursor: ListNode = head
        (toBig(l1) + toBig(l2)).toString().reversed().forEach {
            cursor.next = ListNode(it.toString().toInt())
            cursor = cursor.next!!
        }
        return if (head.next != null) head.next else head
    }
}

fun main(args: Array<String>) {
    val test = Solution()
    val l1 = cat1.p2.v2.ListNode(2, cat1.p2.v2.ListNode(4, ListNode(3)))
    val l2 = cat1.p2.v2.ListNode(5, cat1.p2.v2.ListNode(6, ListNode(4)))
    val ret = test.addTwoNumbers(l1, l2)
    print(ret)
}