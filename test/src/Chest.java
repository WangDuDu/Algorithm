import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by wangshuyang on 2018-4-18.
 */
public class Chest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] stringArray = string.split(" ");
        int year = Integer.parseInt(stringArray[0]);
        int weak = Integer.parseInt(stringArray[1]);
        System.out.println(getResult(year, weak));

    }

    public static int getResult(int year, int weak) {
        if (year > 400 || year <0)
            return -1;
        if (!(weak >= 0 && weak <= 6))
            return -1;
        int startYear =1900;
        int count = 0;
        //SimpleDateFormat Sdf = new SimpleDateFormat("yyyy-MM-dd E");
        int k = 0;
        try {
            Calendar cal = Calendar.getInstance();
            while (k < year) {
                for (int i = 0; i < 12; i++) {
                    cal.set(startYear, i, 13);
                    if (weak == (cal.get(Calendar.DAY_OF_WEEK) - 1)) {
                        //System.out.println("黑色星期" + weak + Sdf.format(cal.getTime()));
                        count++;

                    }
                }
                startYear++;
                k++;
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}