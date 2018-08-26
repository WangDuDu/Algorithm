import java.util.*;

/**
 * Created by wangshuyang on 2018-8-25.
 */
public class CodeDance2 {
    public static int[] array = null;
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Map<Integer,List> map = new HashMap<Integer, List>();
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            String[] stringArray = string.split(" ");
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < stringArray.length; j++) {
               list.add(Integer.parseInt(stringArray[j]));
            }
            map.put(i + 1, list);
        }
        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (array[i] == 0) {
                getResult(n, i, map);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void getResult(int n, int i, Map<Integer,List> map) {
        array[i] = 1;
        List<Integer> list = map.get(i);
        for (Integer integer : list) {
            if (integer != 0 && array[integer] == 0) {
                getResult(n, integer, map);
            }
        }

    }
}
