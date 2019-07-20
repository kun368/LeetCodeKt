package cat1.cat11.cat111.p1114.v2;

public class Main {
    public static void main(String[] args) {
        final Foo foo = new Foo();
        new Thread(() -> foo.first(() -> System.out.println("first"))).start();
        new Thread(() -> foo.second(() -> System.out.println("second"))).start();
        new Thread(() -> foo.third(() -> System.out.println("third"))).start();
    }
}
