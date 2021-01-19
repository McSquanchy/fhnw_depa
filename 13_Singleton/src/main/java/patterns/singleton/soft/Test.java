package patterns.singleton.soft;

public class Test {

    public static void main(String[] args) {
        Singleton.test();
        Singleton s = Singleton.getInstance();
        s.toString();
        Singleton.test();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
       Singleton.test();

    }
}
