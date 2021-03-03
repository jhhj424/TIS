package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/9095
 */
public class Boj9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] d = new int[12];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= 11; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(d[sc.nextInt()]);
        }
    }
}
