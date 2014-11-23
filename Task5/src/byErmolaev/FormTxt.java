package byErmolaev;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class FormTxt {
    public void writer() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("input.txt");

        for (int i = 1; i <= 999; i++) {
            int c = (int) (Math.random() * 100);
            pw.print(c + " ");
            if (i % 10 == 0) {
                pw.println("");
            }
        }
        pw.close();

    }

    public static void main(String[] args) {
        FormTxt f = new FormTxt();
        try {
            f.writer();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
