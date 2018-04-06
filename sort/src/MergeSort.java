import java.util.Random;

/**
 * Created by wangshuyang on 2017/4/5.
 */
public class MergeSort {

    public static void print(int[] array, int length){
        for (int i = 0; i < length; i++){
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (int flag = 0; flag < k; flag++) {
            array[left + flag] = temp[flag];
        }
    }

    public static void mergeArray(int[] array, int left, int right, int[] temp){
        if (left < right) {
            int mid = (left + right) / 2;
            mergeArray(array, left, mid, temp);
            mergeArray(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] intTemp = new int[10];
        int[] intArray = new int[10];
        for (int i = 0; i < 10; i++) {
            intArray[i] = random.nextInt(100);
        }
        print(intArray,10);
        mergeArray(intArray, 0, 9, intTemp);
        print(intArray,10);
    }
}
