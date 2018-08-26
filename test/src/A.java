import java.util.Scanner;

public class A {
    int n, k;
    int a[] = new int[1000005];
    int b[] = new int[100005];
    int dp[] = new int[100005]; //i清醒时的后边总共的权值
    int dp1[] = new int[100005]; //i清醒时的后边如果为1总共的权值
    Scanner scanner;

    public void solve() {
        scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = a[i] + dp[i + 1];
            dp1[i] = dp1[i + 1];
            if (b[i] == 1) {
                dp1[i] += a[i];
            }
        }
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                sum += a[i];
            } else {
                int j = Math.min(i + k - 1, n); // 从当前叫醒位置往后数k个数后的位置
                ans = Math.max(ans, sum + dp[i] - dp[j + 1] + dp1[j + 1]);
            }
        }
        ans = Math.max(ans, sum);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        new A().solve();
    }

}