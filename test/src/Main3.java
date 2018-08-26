/**
 * Created by wangshuyang on 2018-4-18.
 */
public class Main3 {
    private static int[] DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {

        System.out.println(getResult(1, 3));
    }

    private static int getResult(int years, int weeks) {

        try {
            int count = 0;
            int week = 1;
            for (int i = 1900; i <= 1900 + years; i++) {
                for (int j = 1; j <= 12; j++) {
                    int day = getDay(i, j);
                    for (int k = 1; k <= day; k++) {
                        if (i == 1900 + years && j == 1 && k == 1) {
                            return count;
                        }
                        if (k != 13) {
                            continue;
                        }
                        if (week == weeks) {
                            System.out.println(i + "-" + j + "-" + k + ",星期" + week);
                            count++;
                        }
                        week++;
                        if (week == 6) {
                            week = 0;
                        }
                    }
                }
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static int getDay(int year, int month) {

        if (!runnian(year)) {
            return DAYS[month - 1];
        }

        return month == 2 ? 29 : 28;
    }

    private static boolean runnian(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
