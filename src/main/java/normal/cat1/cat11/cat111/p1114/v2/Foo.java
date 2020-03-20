package normal.cat1.cat11.cat111.p1114.v2;

class Foo {

    private volatile int x = 0;

    public void first(Runnable printFirst) {
        printFirst.run();
        x = 1;
    }

    public void second(Runnable printSecond) {
        while (true) {
            if (x == 1) {
                printSecond.run();
                x = 2;
                break;
            }
        }
    }

    public void third(Runnable printThird) {
        while (true) {
            if (x == 2) {
                printThird.run();
                break;
            }
        }
    }
}