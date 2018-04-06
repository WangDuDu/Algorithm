import java.util.Random;

/**
 * Created by wangshuyang on 2017/4/5.
 */
public class QuickSort {

    public static void print(int[] array, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static int partition(int[] array, int low, int high){
        int pivotkey = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivotkey) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivotkey) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = pivotkey;
        return high;
    }

    public static void quick(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);
            quick(array,low,index-1);
            quick(array,index+1,high);
        }
    }

    public static void main(String args[]){
        Random random = new Random();
        int[] intArray = new int[10];
        for (int i = 0; i < 10; i++) {
            intArray[i] = random.nextInt(100);
        }
        print(intArray,10);
        quick(intArray,0,9);
        print(intArray,10);
    }
}
