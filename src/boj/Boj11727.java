package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/11727
 */
public class Boj11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]*2) % 10_007;
        }
        System.out.println(dp[n]);
    }
}
