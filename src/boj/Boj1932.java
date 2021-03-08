package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1932
 */
public class Boj1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = sc.nextInt();
                if (i == j) break;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + dp[i][j], dp[i-1][j] + dp[i][j]);
                if (i == j) break;
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[n][i], max);
        }
        System.out.println(max);
    }
}