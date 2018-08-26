import java.util.*;

/**
 * Created by wangshuyang on 2018-8-12.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> person = new ArrayList<Integer>();
        List<Integer> team = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            person.add(key);
            team.add(value);
            map.put(key, value);
        }
    }

}
