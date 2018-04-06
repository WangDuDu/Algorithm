/**
 * Created by wangshuyang on 2018-4-6.
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

    public static void init (boolean[] flags) {
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }
    }

    public static void crossOff (boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    public static int getNextPrime (boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && flags[next] == false) {
            next++;
        }

        return next;
    }

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
