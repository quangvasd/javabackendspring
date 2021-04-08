package vn.plusplus.threading.Ex2;

public class MyThread extends Thread {
    private String name;
    private int sleep;

    public MyThread(String name, int sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    public MyThread() {
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
        }
    }
}
