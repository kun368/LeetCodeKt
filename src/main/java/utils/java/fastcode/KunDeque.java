package utils.java.fastcode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 手写双端队列
 */
@SuppressWarnings({"unchecked", "UnusedReturnValue"})
public class KunDeque<E> {

    private Object[] es;
    private int head = 0, tail = 0;

    public KunDeque() {
        es = new Object[1];
    }

    private int mod(int i) {
        return (i + es.length) % es.length;
    }

    private void expand() {
        Object[] newElements = new Object[es.length * 2];
        System.arraycopy(es, head, newElements, 0, es.length - head);
        System.arraycopy(es, 0, newElements, es.length - head, head);
        head = 0;
        tail = es.length;
        es = newElements;
    }

    public void pushFront(E e) {
        head = mod(head - 1);
        es[head] = e;
        if (head == tail) expand();
    }

    public void pushBack(E e) {
        es[tail] = e;
        tail = mod(tail + 1);
        if (head == tail) expand();
    }

    public E popFront(boolean remove) {
        E e = (E) es[head];
        if (remove) {
            es[head] = null;
            head = mod(head + 1);
        }
        return e;
    }

    public E popBack(boolean remove) {
        int lastIndex = mod(tail - 1);
        E e = (E) es[lastIndex];
        if (remove) tail = lastIndex;
        return e;
    }

    public int size() {
        return mod(tail - head);
    }

    public E get(int index) {
        return (E) es[mod(head + index)];
    }

    public String toString() {
        return IntStream.range(0, size()).boxed().map(this::get).collect(Collectors.toList()).toString();
    }
}