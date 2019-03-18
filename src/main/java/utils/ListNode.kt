package utils

class ListNode(var `val`: Int, var next: ListNode? = null) {

    companion object {
        fun parse(str: String): ListNode? {
            val head = ListNode(-1)
            var cur = head
            str.split("->").map { it.toInt() }.forEach {
                cur.next = ListNode(it)
                cur = cur.next!!
            }
            return head.next
        }
    }

    override fun toString(): String {
        return "$`val`->$next"
    }
}