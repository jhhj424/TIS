package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/9251
 */
public class Boj9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] a1 = s1.split("");
        String[] a2 = s2.split("");
        int[][] d = new int[a1.length+1][a2.length+1];
        for (int i = 1; i <= a1.length; i++) {
            for (int j = 1; j <= a2.length; j++) {
                if (a1[i-1].equals(a2[j-1])) {
                    d[i][j] = d[i-1][j-1] + 1;
                } else {
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }
        System.out.println(d[a1.length][a2.length]);
    }
}
