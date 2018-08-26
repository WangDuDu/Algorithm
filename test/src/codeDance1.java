import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangshuyang on 2018-8-12.
 */
public class codeDance1 {

    private static int number = 0;
    private static int result = 0;

    private static int[][] rect = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        String[] stringArray = test.split(",");
        int M = Integer.parseInt(stringArray[0]);
        int N = Integer.parseInt(stringArray[1]);
        rect = new int[M][N];
        for (int i = 0; i < M; i++) {
            String test1 = scanner.nextLine();
            String[] stringArray1 = test1.split(",");
            for (int j = 0; j < N; j++) {
                rect[i][j] = Integer.parseInt(stringArray1[j]);
//                System.out.print(rect[i][j] + ",");
            }
//            System.out.println();
        }

        List<Integer> numberList = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                number = 0;
                if (rect[i][j] == 1) {
                    block(i, j);
                    count++;
                }
                numberList.add(number);
                result = number > result ? number : result;
            }
        }

        System.out.println(count + "," + result);


    }

    private static void block(int i, int j) {
        // 修改(i,j)坐标对应的数组元素的值(避免递归时反复判断相邻元素)
        rect[i][j] = 4;
        number++;
        // 分别判断上下左右
        if (i < rect.length - 1 && rect[i + 1][j] == 1) {
            block(i + 1, j);
        }
        if (i > 0 && rect[i - 1][j] == 1) {
            block(i - 1, j);
        }
        if (j < rect[i].length - 1 && rect[i][j + 1] == 1) {
            block(i, j + 1);
        }
        if (j > 0 && rect[i][j - 1] == 1) {
            block(i, j - 1);
        }

        if (i < rect.length - 1 && j > 0 && rect[i + 1][j - 1] == 1) {
            block(i + 1, j - 1);
        }
        if (i < rect.length - 1 && j < rect[i].length && rect[i + 1][j + 1] == 1) {
            block(i + 1, j + 1);
        }
        if (i > 0 && j > 0 && rect[i - 1][j - 1] == 1) {
            block(i - 1, j - 1);
        }
        if (i > 0 && j < rect[i].length && rect[i - 1][j + 1] == 1) {
            block(i - 1, j + 1);
        }
    }


}
