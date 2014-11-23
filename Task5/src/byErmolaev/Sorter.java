package byErmolaev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Sorter implements Runnable {

    private List<Integer> al;
    private Semaphore semaphore;
    private List<Integer> firstAl = new ArrayList<Integer>();
    private List<Integer> secondAl = new ArrayList<Integer>();
    private List<Integer> thirdAl = new ArrayList<Integer>();

    public Sorter(List<Integer> al, Semaphore semaphore) {
        this.al = al;
        this.semaphore = semaphore;
        sort(al);
    }

    public void clear() {
        firstAl.clear();
        secondAl.clear();
        thirdAl.clear();
    }

    public synchronized void sort(List<Integer> al) {

        for (int i = 0; i < al.size(); i++) {
           int num= al.get(i);
            Config.writeln("There is: "+ num);
            if (num % 3 == 0) {
                firstAl.add(num);
            } else if (num % 3 == 1) {
                secondAl.add(num);
            } else {
                thirdAl.add(num);
            }
        }
        Writer.write(firstAl, 1);
        Writer.write(secondAl, 2);
        Writer.write(thirdAl, 3);
//        this.clear();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        for (int num : firstAl) {
        for (int i = 0; i < this.al.size(); i++) {
            int num= this.al.get(i);
            if (num % 3 == 0) {
                firstAl.add(num);
            } else if (num % 3 == 1) {
                secondAl.add(num);
            } else {
                thirdAl.add(num);
            }
        }
        Writer.write(firstAl, 1);
        Writer.write(secondAl, 2);
        Writer.write(thirdAl, 3);

        semaphore.release();
    }

}
