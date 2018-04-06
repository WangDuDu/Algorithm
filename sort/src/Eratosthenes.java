/**
 * Created by wangshuyang on 2018-4-6.
 * 埃拉托斯特尼筛法
 * input 输入的是一个max代表要求出从0到max的所有素数
 * ouput 输出的是0到max的所有素数
 */
public class Eratosthenes {
    public static boolean[] sieveOfEratosthenes (int max) {
        boolean[] flags = new boolean[max + 1];

        init(flags);//在flags中将除了0,1之外的所有数字的状态置位true

        int prime = 2;

        while (prime < max) {
            crossOff(flags, prime);crossOff(flags, prime);

            prime = getNextPrime(flags, prime);

            if (prime >= flags.length)
                break;

        }

        return flags;

    }

    /*
     * 初始化boolean数组,除了0,1之外全部初始化为false
     */
    public static void init (boolean[] flags) {
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }
    }

    /*
     * 划掉所有可能被prime整除的数,要保留prime本身,
     * 所以遍历从prime*prime开始,因为如果如果k*prime且k<prime
     * 这个值早就在之前的迭代中被划掉了
     */
    public static void crossOff (boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    /*
    找出下一个素数
     */
    public static int getNextPrime (boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && flags[next] == false) {
            next++;
        }

        return next;
    }

    /*
     * 打印出最后的结果
     */
    public static void print (boolean[] flags) {
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == true) {
                System.out.print(i + " , ");
            }
        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int max = scanner.nextInt();

        int max = 11;

        boolean[] flags = sieveOfEratosthenes(max);

        print(flags);
    }
}
