import java.util.Random;

/**
 * Created by wangshuyang on 2017/4/5.
 */
public class BubbleSort {

    public static void print(int[] array, int n){
        for (int i = 0; i < n; i++){
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void bubble(int[] array, int length){
        int temp;
        for (int i = 0; i < length-1; i++){
            for (int j = 0; j < length - i -1; j++){
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] intArray = new int[10];
        for (int i = 0; i < 10; i++){
            intArray[i] = random.nextInt(100);
        }
        print(intArray,10);
        bubble(intArray,10);
        print(intArray,10);
    }
}
