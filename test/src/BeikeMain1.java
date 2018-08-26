
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangshuyang on 2018-8-18.
 */
public class BeikeMain1 {

    private static class Zone {
        int left;
        int right;
        int index;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= 1) {
            System.out.println(0);
            return;
        }
        Zone[] z = new Zone[number];
        for (int i = 0; i < number; i++) {
            z[i] = new Zone();
            z[i].left = scanner.nextInt();
            z[i].right = scanner.nextInt();
            z[i].index = i + 1;
        }

        Arrays.sort(z, new Comparator<Zone>() {
            @Override
            public int compare(Zone o1, Zone o2) {
                return o1.right - o2.right;
            }
        });

        Stack<Zone> stack = new Stack<Zone>();

        int i = 1;
        Zone key = z[0];
        stack.push(z[0]);

        while (i < z.length) {
            if (key.right <= z[i].left) {
                stack.push(z[i]);
                key = z[i];
            }
            i++;
        }

        if (stack.size() == number) {
            System.out.println(number);
            for (int j = 0; j < number; j++) {
                System.out.print(j + 1 + " ");
            }
        } else if (stack.size() < number - 1) {
            System.out.println(0);
        } else if (stack.size() == number - 1) {
            for (int j = 0; j < number; j++) {
                if (!stack.contains(z[j])) {
                    if (j >= 2 && z[j - 2].right > z[j].left) {
                        System.out.println(1);
                        System.out.print(z[j].index + " ");
                    } else {
                        System.out.println(2);
                        Zone[] result = new Zone[2];
                        result[0] = z[j].index < z[j - 1].index ? z[j] : z[j - 1];
                        result[1] = z[j].index > z[j - 1].index ? z[j] : z[j - 1];
                        System.out.println(result[0].index + " " + result[1].index);
                    }
                }
            }
        }

    }
}
