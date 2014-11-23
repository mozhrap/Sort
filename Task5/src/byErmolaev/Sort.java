package byErmolaev;

import java.util.ArrayList;

public class Sort {
    ArrayList<Integer> firstAl = new ArrayList<Integer>();
    ArrayList<Integer> secondAl = new ArrayList<Integer>();
    ArrayList<Integer> thirdAl = new ArrayList<Integer>();
    Writer w = new Writer();

    public void clear() {
        firstAl.clear();
        secondAl.clear();
        thirdAl.clear();
    }

    public void sort(ArrayList<Integer> al) {

        for (int num : al) {
            if (num % 3 == 0) {
                firstAl.add(num);
            } else if (num % 3 == 1) {
                secondAl.add(num);
            } else {
                thirdAl.add(num);
            }
        }
//			secondAl.addAll(thirdAl);
//			firstAl.addAll(secondAl);
        w.write(firstAl, 1);
        w.write(secondAl, 2);
        w.write(thirdAl, 3);
        this.clear();
    }

}
