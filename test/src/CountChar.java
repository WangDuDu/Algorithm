import java.util.Scanner;

/**
 * Created by wangshuyang on 2018-4-17.
 */
public class CountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] stringArray = scanner.nextLine().toUpperCase().toCharArray();
        char target = scanner.nextLine().toUpperCase().toCharArray()[0];

        int count =0;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == target)
                count ++;
        }

        System.out.println(count);

    }
}
