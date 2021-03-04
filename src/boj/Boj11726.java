package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/11726
 */
public class Boj11726 {
    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        System.out.println(f(n));
    }

    private static int f(int n) {
        if (n < 3) return n;
        if (d[n] != 0) return d[n];
        return d[n] = (f(n-2) + f(n-1)) % 10_007;
    }
}
