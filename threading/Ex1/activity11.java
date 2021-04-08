package vn.plusplus.threading.Ex1;

public class activity11 extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
