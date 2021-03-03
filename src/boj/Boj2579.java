package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2579
 */
public class Boj2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[][] d = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(a[1]);
            return;
        }
        d[1][1] = a[1];
        d[1][2] = 0;
        d[2][1] = a[2];
        d[2][2] = a[1] + a[2];
        for (int i = 3; i <= n; i++) {
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + a[i];
            d[i][2] = d[i-1][1] + a[i];
        }
        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}
