package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/12852
 */
public class Boj12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        int[] pre = new int[n+1];
        for (int i = 2; i < n+1; i++) {
            d[i] = d[i-1] + 1;
            pre[i] = i - 1;
            if (i % 2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
                pre[i] = i / 2;
            }
            if (i % 3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
                pre[i] = i / 3;
            }
        }
        System.out.println(d[n]);
        int i = n;
        while (true) {
            System.out.print(i + " ");
            i = pre[i];
            if (i == 0) break;
        }
    }
}
