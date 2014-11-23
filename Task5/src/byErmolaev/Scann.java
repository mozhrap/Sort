package byErmolaev;

import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scann {


    private List<Integer> al;

    // private int size;

    public void start() {
        try {
            this.reader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reader() throws Exception {
        Config config = new Config();
        Writer wr = new Writer();
        BufferedReader br = new BufferedReader(new FileReader(
                config.getInputPath()));
        Semaphore semaphore = new Semaphore(3);
        al = new ArrayList<Integer>();

        while (br.ready()) {
            String str = "";
            str = br.readLine();
            String[] decDev;
            decDev = str.split(" ");
            int n;
            for (int i = 0; i < decDev.length; i++) {
                try {
                    n=Integer.parseInt(decDev[i]);
                    al.add(n);
                } catch (NumberFormatException e) {
                    Config.writeln("Be carefully. It's not a number!");
                }
            }
            new Thread(new Sorter(al, semaphore)).start();
            al.clear();
        }
        Writer.pw.close();
        br.close();
        config.finish();
    }

    public boolean checkWithRegExp(String userNameString) {
        Pattern p = Pattern.compile("^(-?[0-9]+\\s){1,10}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}