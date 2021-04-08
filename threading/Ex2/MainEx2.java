package vn.plusplus.threading.Ex2;

public class MainEx2 {
    public static void main(String[] args) {
        MyThread th1 = new MyThread("ABC",3500);
        MyThread th2 = new MyThread("DEF",2500);

        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {}
        th2.start();
    }
}
