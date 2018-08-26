import java.util.Random;

/**
 * Created by wangshuyang on 2018-8-12.
 */
public class LCS {
    public String getRandomString(int length) {
        StringBuilder result = new StringBuilder();
        String element = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] elements = element.toCharArray();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(elements[random.nextInt(element.length())]);
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        lcs.getRandomString(10);
    }

}
