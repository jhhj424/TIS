package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/11659
 */
public class Boj11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sumArr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i-1] + sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sumArr[end] - sumArr[start-1]);
        }
    }
}
