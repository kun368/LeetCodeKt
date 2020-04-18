package match.weekly.weekly180.p2;

import java.util.ArrayList;
import java.util.List;

class CustomStack {

    private List<Integer> list = new ArrayList<>();
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (list.size() >= maxSize) {
            return;
        }
        list.add(x);
    }

    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(list.size() - 1);
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < list.size(); ++i) {
            list.set(i, list.get(i) + val);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // 栈是空的 []
        customStack.push(1);                          // 栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        System.out.println(customStack.pop());                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.push(3);                          // 栈变为 [1, 2, 3]
        customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
        System.out.println(customStack.pop());                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        System.out.println(customStack.pop());                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        System.out.println(customStack.pop());                            // 返回 201 --> 返回栈顶值 201，栈变为 []
        System.out.println(customStack.pop());                            // 返回 -1 --> 栈为空，返回 -1
    }
}
