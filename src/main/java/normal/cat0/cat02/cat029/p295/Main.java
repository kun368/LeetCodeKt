package normal.cat0.cat02.cat029.p295;


import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * <p>
 * 利用两个优先队列：左边是最大堆，右边是最小堆，然后不断维护他们一边一半数字即可
 */
class MedianFinder {

    private PriorityQueue<Integer> leftQu, rightQu;

    public MedianFinder() {
        this.leftQu = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        this.rightQu = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftQu.isEmpty() || num <= leftQu.peek()) {
            leftQu.add(num);
            if (leftQu.size() > rightQu.size() + 1) {
                rightQu.add(leftQu.poll());
            }
        } else {
            rightQu.add(num);
            if (rightQu.size() > leftQu.size()) {
                leftQu.add(rightQu.poll());
            }
        }
    }

    public double findMedian() {
        if (leftQu.size() == 0) {
            return 0;
        } else if (leftQu.size() == rightQu.size()) {
            return (leftQu.peek() + rightQu.peek()) / 2.0;
        } else {
            return leftQu.peek();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian()); // 1.5
        finder.addNum(3);
        System.out.println(finder.findMedian()); // 2
    }
}
