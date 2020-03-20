package normal.cat1.cat11.cat111.p1115.v3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FooBar {

    private int n;
    private BlockingQueue<Object> fooQu = new ArrayBlockingQueue<>(1);
    private BlockingQueue<Object> barQu = new ArrayBlockingQueue<>(1);

    public FooBar(int n) {
        this.n = n;
        fooQu.offer(new Object());
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooQu.take();
            printFoo.run();
            barQu.offer(new Object());
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barQu.take();
            printBar.run();
            fooQu.offer(new Object());
        }
    }
}