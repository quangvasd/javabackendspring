package vn.plusplus.threading.Ex3;

import sun.applet.Main;

import java.util.Random;

public class MainEx3 {
    public static int sleep = 2000;
    public static int year;
    public static boolean flag = false;

    public static void main(String[] args) {
        CheckNumber c1 = new CheckNumber();
        GenNumber c2 = new GenNumber();


        c1.start();
        c2.start();
    }


}

class GenNumber extends Thread{
    @Override
    public void run() {
        while (true){
            Random r = new Random();
            MainEx3.year = r.nextInt(999) +1000;
            System.out.println(Thread.currentThread().getName()+": Gen ra so "+MainEx3.year);
            MainEx3.flag = false;
            try {
                Thread.sleep(MainEx3.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CheckNumber extends Thread{
    @Override
    public void run() {
        while (true){
            if (MainEx3.year % 4 ==0 && MainEx3.year % 100 != 0){
                System.out.println(Thread.currentThread().getName()+": So"+MainEx3.year+" la nam nhuan");
            }else {
                System.out.println(Thread.currentThread().getName()+": So"+ MainEx3.year+ "khong la nam nhuan");
            };MainEx3.flag = false;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
