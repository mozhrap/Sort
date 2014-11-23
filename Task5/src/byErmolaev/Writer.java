package byErmolaev;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

public class Writer {
    static PrintWriter pw;

    public Writer() {
//		Config config = new Config();
        try {
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(Config.getOutputPath())));
        } catch (FileNotFoundException e) {
            Config.writeln("There is something with file-not found");
            e.printStackTrace();
        }
    }

    public void close() {
        pw.close();
    }

    public static synchronized void write(List<Integer> al, int n) {

        pw.print("[");

        for (int num : al) {
            pw.print(num + " ");
        }
        pw.print("]");
        switch (n) {
            case 1:
                pw.print("делятся на 3 без остатка");
                break;
            case 2:
                pw.print("делятся на 3 с остатком 1");
                break;
            case 3:
                pw.print("делятся на 3 с остатком 2");
                pw.println("");
                break;
            default:
                pw.print("хмм");
        }
        pw.println("");


    }

}
