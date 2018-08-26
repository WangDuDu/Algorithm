import java.util.Scanner;

/**
 * Created by wangshuyang on 2018-8-12.
 */
public class Main7 {
    public static void input(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0){
            System.out.println(0);
            return;
        }
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int j=0;j<n;j++){
            b[j] = sc.nextInt();
        }

        if(n==1){
            if(a[0]<b[0]){
                System.out.println(1);
            }else {
                System.out.println(0);
                return;
            }
        }
        int size = 0;
        for(int i=0;i<n;i++){
            if(a[i]>=b[i]){
                continue;
            }
            size++;
            for(int j=i+1;j<n;j++){
                if(a[j]>=b[j]){
                    break;
                }
                size++;
            }
        }
        System.out.println(size);
    }
    public static void main(String[] args) {
        input();
    }
}
