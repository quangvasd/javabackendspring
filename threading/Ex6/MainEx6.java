package vn.plusplus.threading.Ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MainEx6 {
    public static Integer maxUoc = 1;
    public static List<Integer> result = new ArrayList<>();
    public static BlockingQueue<Integer> input = new LinkedBlockingQueue<>();
    public static void main(String[] args) throws InterruptedException {
        for(int i = 1; i<100000; i++){
            input.put(i);
        }
        System.out.println("Start: "+System.currentTimeMillis());
        int numThread = 20;
        for(int i = 0; i<numThread; i++){
            Thread th = new CheckNumber();
            th.start();
        }
    }
}

class CheckNumber extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                Integer num = MainEx6.input.poll(100, TimeUnit.MILLISECONDS);
                if(num != null){
                    int soUoc = timSoUoc(num);
                    updateMax(num, soUoc);
                } else {
                    print();
                    Thread.currentThread().stop();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Integer timSoUoc(int number){
        int counter = 0;
        for(int i = 1; i<= number; i++){
            if(number%i ==0){
                counter ++;
            }
        }
        return counter;
    }
    private synchronized void updateMax(int number, int soUoc){
        if(MainEx6.maxUoc < soUoc){
            MainEx6.maxUoc = soUoc;
            MainEx6.result.clear();
            MainEx6.result.add(number);
        } else if(MainEx6.maxUoc == soUoc){
            MainEx6.result.add(number);
        }
    }
    private void print(){
        System.out.println(System.currentTimeMillis() + ": " +MainEx6.result.toString() + " co max uoc: " + MainEx6.maxUoc);

    }
}
