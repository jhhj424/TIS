package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/10026
 */
public class Boj10026 {
    static int n;
    static String[][] map1, map2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        map1 = new String[n][n];
        map2 = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                map1[i][j] = map2[i][j] = strings[j];
                if (map2[i][j].equals("G")) map2[i][j] = "R";
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j].equals("X")) continue;
                dfs(i,j, map1[i][j], map1);
                cnt++;
            }
        }
        System.out.print(cnt);

        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map2[i][j].equals("X")) continue;
                dfs(i,j, map2[i][j], map2);
                cnt++;
            }
        }
        System.out.print(" " + cnt);
    }

    private static void dfs(int i, int j, String s, String[][] map) {
        if (i < 0 || j < 0 || i >= n || j >= n) return;
        if (map[i][j].equals("X") || !map[i][j].equals(s)) return;
        map[i][j] = "X";
        dfs(i+1,j,s, map);
        dfs(i-1,j,s, map);
        dfs(i,j+1,s, map);
        dfs(i,j-1,s, map);
    }
}
