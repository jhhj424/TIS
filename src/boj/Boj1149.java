package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1149
 */
public class Boj1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][4];
        int[][] dp = new int[n+1][4];
        for (int i = 1; i <= n; i++) {
            d[i][1] = sc.nextInt();
            d[i][2] = sc.nextInt();
            d[i][3] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            dp[i][1] = Math.min(dp[i-1][2],dp[i-1][3]) + d[i][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][3]) + d[i][2];
            dp[i][3] = Math.min(dp[i-1][2],dp[i-1][1]) + d[i][3];
        }
        System.out.println(Math.min(Math.min(dp[n][1], dp[n][2]), dp[n][3]));
    }
}
