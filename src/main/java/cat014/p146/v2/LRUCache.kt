package cat014.p146.v2

class MyCache(val capacity: Int) : LinkedHashMap<Int, Int>(16, 0.75f, true) {
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
        return size > capacity
    }
}

class LRUCache(capacity: Int) {
    val cache = MyCache(capacity)
    fun get(key: Int) = cache[key] ?: -1
    fun put(key: Int, value: Int) = cache.put(key, value)
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
