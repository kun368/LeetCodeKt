package utils.java.fastcode;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class Pair<K, V> implements Comparable<Pair<K, V>> {

    public K L;
    public V R;

    public Pair(K l, V r) {
        L = l;
        R = r;
    }

    private <E> int compare(E a, E b) {
        return ((Comparable<? super E>) a).compareTo(b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(L, pair.L) && Objects.equals(R, pair.R);
    }

    @Override
    public int hashCode() {
        return Objects.hash(L, R);
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        int t = compare(this.L, o.L);
        return t == 0 ? compare(this.R, o.R) : t;
    }

    @Override
    public String toString() {
        return "(" + L + ", " + R + ")";
    }
}
