package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1987
 */
public class Boj1987 {
    static int r,c,cnt;
    static char[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        map = new char[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = line[j].charAt(0);
            }
        }

        cnt = 0;
        dfs(0,0, 1);
        System.out.println(cnt);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void dfs(int a, int b, int d) {
        if (a < 0 || b < 0 || a >= r || b >= c ) return;
        if (visited[map[a][b] - 'A']) return;
        visited[map[a][b] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            dfs(a + dx[i], b + dy[i], d + 1);
        }
        visited[map[a][b] - 'A'] = false;
        cnt = Math.max(cnt, d);
    }
}
