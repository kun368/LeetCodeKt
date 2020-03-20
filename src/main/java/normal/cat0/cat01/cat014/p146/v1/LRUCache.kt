package normal.cat0.cat01.cat014.p146.v1


class LRUCache(capacity: Int) {

    data class Node(val k: Int, var v: Int, var prev: Node? = null, var next: Node? = null)

    private val size: Int = capacity
    private val map = hashMapOf<Int, Node>()
    private val head: Node
    private val tail: Node

    init {
        head = Node(-1, -1)
        tail = Node(-2, -2)
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        remove(node)
        setHead(node)
        return node.v
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.v = value
            remove(node)
            setHead(node)
        } else {
            if (map.size >= size) {
                map.remove(tail.prev!!.k)
                remove(tail.prev!!)
            }
            val add = Node(key, value)
            setHead(add)
            map[key] = add
        }
    }

    private fun remove(node: Node) {
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
    }

    private fun setHead(node: Node) {
        val pnext = head.next!!
        head.next = node
        node.next = pnext
        pnext.prev = node
        node.prev = head
    }
}

fun main(args: Array<String>) {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1))
    cache.put(3, 3)
    println(cache.get(2))
    cache.put(4, 4)
    println(cache.get(1))
    println(cache.get(3))
    println(cache.get(4))
}
