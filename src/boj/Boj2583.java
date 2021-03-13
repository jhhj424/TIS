package boj;

import java.util.*;

/*
https://www.acmicpc.net/problem/2583
 */
public class Boj2583 {
    static int n,m,k;
    static int[][] map;
    static int size = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < k; i++) {
            int x2 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int y1 = sc.nextInt();
            for (int a = x1; a < y1; a++) {
                for (int b = x2; b < y2; b++) {
                    map[a][b] = 1;
                }
            }
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) continue;
                dfs(i,j);
                cnt++;
                list.add(size);
                size = 0;
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    private static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        if (map[i][j] != 0) return;
        map[i][j] = 1;
        size++;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
}
