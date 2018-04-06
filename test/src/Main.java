import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wangshuyang on 2018-3-24.
 */
public class Main {

    public static boolean check(ArrayList<String> list, String s1, String s2) {
        for (String string:list) {
            if (s1.compareTo(string) == 0 || s2.compareTo(string) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i] - array[j]) == k || (array[j] - array[i]) == k) {
                    String s1 = array[i] + " " + array[j];
                    String s2 = array[j] + " " + array[i];
                    if (check(list, s1, s2)) {
                        list.add(s1);
                    }
                }
            }
        }
        System.out.println(list.size());
    }

}
