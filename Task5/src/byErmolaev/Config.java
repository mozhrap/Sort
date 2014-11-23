package byErmolaev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Config {
    private Scanner config;
    private static String inpath, outpath;
    private static PrintWriter out;
    static Date time;

    public Config() {
        try {
            out = new PrintWriter("log.txt");
            config = new Scanner(new FileInputStream("config.txt"));
            writeln("Считывание конфиг файла");
            inpath = config.next();
            outpath = config.next();
        } catch (FileNotFoundException e) {
            writeln("Конфиг файл не найден");
            e.printStackTrace();
        }
    }

    public String getInputPath() {
        return inpath;
    }

    public static String getOutputPath() {
        return outpath;
    }

    public static synchronized void writeln(String str) {
        time = new Date();
        DateFormat formatter = new SimpleDateFormat("[dd.MM.yyyy] [HH.mm.ss] ");
        out.println(formatter.format(time) + "[" + Config.class.getName() + "]" + str);
    }

    public void finish() {

        writeln("Сортировка прошла успешно");
        out.close();
    }
}
