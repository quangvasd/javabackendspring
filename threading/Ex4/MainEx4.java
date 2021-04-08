package vn.plusplus.threading.Ex4;

import java.util.HashMap;
import java.util.Random;

public class MainEx4 {
    public static HashMap<String,String> week = new HashMap<>();
    public static boolean flag = true;
    public static String day ="";

    public static void main(String[] args) {
        week.put("Monday","Thu 2");
        week.put("Tuesday","Thu 3");
        week.put("Wednesday","Thu 4");
        week.put("Thurday","Thu 5");
        week.put("Friday","Thu 6");
        week.put("Saturday","Thu7");
        week.put("Sunday", "Chu nhat");

        DayRand dayRand = new DayRand();
        dayRand.start();
        DayVN dayVN = new DayVN();

        dayVN.start();

    }
}

class DayRand extends Thread{
    private String[] dayOfWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    @Override
    public synchronized void run() {
        while (true){
            Random rand = new Random();
            if (MainEx4.flag = true){
                MainEx4.day = dayOfWeek[rand.nextInt(7)];
                System.out.println(Thread.currentThread().getName()+": Day "+MainEx4.day);
                MainEx4.flag = false;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class DayVN extends Thread{
    @Override
    public synchronized void run() {
        while (true){
            if (MainEx4.flag = true){
                System.out.println(Thread.currentThread().getName()+": DayVN: "+MainEx4.week.get(MainEx4.day));
                MainEx4.flag = false;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
