/**
 * Created by wangshuyang on 2017/4/6.
 */
public class test {
    public static void main(String[] args) {
//        String s = "1234566";
//        char[] chars = s.toCharArray();
//        byte[] bytes = s.getBytes();
//        System.out.println(chars[1]);
//        System.out.println(bytes[1]);
        int m = 23, n = 32;
        int dif = m ^ n;
        dif = dif&(dif-1);
        System.out.println(dif);
    }


}
