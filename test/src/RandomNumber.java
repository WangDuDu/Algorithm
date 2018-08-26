import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by wangshuyang on 2018-4-17.
 */
public class RandomNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<Integer>();
            for (int i = 0; i < count; i++){
                treeSet.add(scanner.nextInt());
            }
            for (Integer i:treeSet) {
                System.out.println(i);
            }
        }
    }
}
