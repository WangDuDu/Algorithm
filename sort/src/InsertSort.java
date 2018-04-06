import java.util.Random;

/**
 * Created by wangshuyang on 2017/3/29.
 * 插入排序算法
 */
public class InsertSort {
    public static void insert(int[] intArray, int length){
        if(intArray==null || length==0){
            return;
        }

        for (int i = 1; i < length; i++){
            int temp = intArray[i];
            int j;
            for (j = i; j > 0 && temp < intArray[j - 1]; j--) {
                intArray[j] = intArray[j - 1];
            }
            intArray[j] = temp;
        }
    }

    public static void print (int[] intArray, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(intArray[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] intArray = new int[10];
        for (int i = 0; i < 10; i++) {
            intArray[i] = random.nextInt(100);
        }

        print(intArray,10);

        insert(intArray,10);

        print(intArray,10);

    }

}
