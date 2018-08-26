import java.util.Scanner;

/**
 * Created by wangshuyang on 2018-4-18.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int length = scanner.nextInt();
        splitString(string,length);
    }

    public static void splitString(String string, int length) {
        int byteLength = 0;

        if (string == null) {
            return;
        }

//        int newLength = 0;
        byte byteArray[] = null;
        try {
            byteArray = string.getBytes("GBK");//采用ISO8859-1编码方式时，一个中文字符与一个英文字符一样只占1个字节；采用GB2312或GBK编码方式时，一个中文字符占2个字节；而采用UTF-8编码方式时，一个中文字符会占3个字节
            byteLength = byteArray.length;
            // 将String转换成byte字节数组

//            for (int i = 0; i < byteLength; i++) {
//                System.out.println(byteArray[i]);
//                if (!(byteArray[i] >= 48 && byteArray[i] <= 57)) {
//                    System.out.println(byteArray[i]);
//                    newLength++;
//                }
//                if (newLength == length)
//                    break;
//            }
            System.out.println(length);

            if (length > byteLength) {
                length = byteLength;
            }

            int num = 0;
            // 判断是否出现了截半，截半的话字节对于的ASC码是小于0的值
            if (byteArray[length - 1] < 0) {
                for (int j = 0; j <= length - 1; j++) {
                    if (byteArray[j] < 0) {
                        num++;
                        num = num % 2;
                    } else {
                        num = 0;
                    }
                }

                if (num == 0) {
                    String subStrx = new String(byteArray, 0, length, "GBK");//前包括后不包括
                    char[] subArray = subStrx.toCharArray();
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < subArray.length; k++) {
                        if (subArray[k] >= 48 && subArray[k] <= 57)
                            continue;
                        else
                            sb.append(subArray[k]);
                    }
                    System.out.println(sb);

                } else {
                    String subStrx = new String(byteArray, 0, length - 1, "GBK");
                    char[] subArray = subStrx.toCharArray();
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < subArray.length; k++) {
                        if (subArray[k] >= 48 && subArray[k] <= 57)
                            continue;
                        else
                            sb.append(subArray[k]);
                    }
                    System.out.println(sb);
                }

            } else {
                String subStrx = new String(byteArray, 0, length, "GBK");
                char[] subArray = subStrx.toCharArray();
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < subArray.length; k++) {
                    if (subArray[k] >= 48 && subArray[k] <= 57)
                        continue;
                    else
                        sb.append(subArray[k]);
                }
                System.out.println(sb);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
