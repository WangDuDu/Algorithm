import java.util.Random;

/**
 * Created by wangshuyang on 2017/4/6.
 */
public class BinarySearch {
    public static void print(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static int binary(int[] array, int val, int left, int right) {
        while (left < right) {
            int mid = (left + right)/2;
            if (val > array[mid]) {
                left = mid + 1;
            } else if (val < array[mid]) {
                right = mid - 1;
            } else {
                right = mid;
            }
        }

        if (array[left] == val) {
            return left;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
//        Random random = new Random();
//        int[] inArray = new int[10];
//        for (int i = 0; i < 10; i++) {
//            inArray[i] = random.nextInt(100);
//        }
//        print(inArray,10);
//        QuickSort qq = new QuickSort();
//        qq.quick(inArray,0,9);
//        print(inArray,10);
        int[] inArray = new int[11];
        for (int i = 0; i < 10; i++) {
            inArray[i] = i+1;
        }
        print(inArray,10);
        int a = binary(inArray,9,0,9);
        System.out.println(a);
    }
}
