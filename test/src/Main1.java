import java.util.Scanner;

/**
 * Created by wangshuyang on 2018-3-24.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = "a";
        String m = s;

    }

    public static String first(String s, String m) {
        m = s;
        s = s + s;
        return s;
    }

    public static String second(String s, String m) {
        s = s + m;
        return s;
    }

    public static void count(String s, String m, int n) {
        count(s.substring(s.length() - m.length() - 1), m, n - m.length());
    }
}
