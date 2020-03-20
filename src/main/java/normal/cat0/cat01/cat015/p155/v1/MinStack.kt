package normal.cat0.cat01.cat015.p155.v1

import java.util.*

class MinStack() {

    private val st = LinkedList<Int>()
    private val min = LinkedList<Int>()

    fun push(x: Int) {
        st.push(x)
        min.push(if (min.isEmpty()) x else minOf(min.first, x))
    }

    fun pop() {
        st.pop(); min.pop()
    }

    fun top() = st.first
    fun getMin() = min.first
}

fun main(args: Array<String>) {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.top())
    println(minStack.getMin())
}