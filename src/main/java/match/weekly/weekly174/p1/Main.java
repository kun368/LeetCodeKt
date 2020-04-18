package match.weekly.weekly174.p1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    static class Node {
        int idx, cnt;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < mat.length; ++i) {
            Node node = new Node();
            node.idx = i;
            for (int j : mat[i]) {
                if (j == 1) node.cnt += 1;
            }
            list.add(node);
        }
        list.sort(Comparator.comparingInt((Node o) -> o.cnt).thenComparingInt(o -> o.idx));

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = list.get(i).idx;
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
