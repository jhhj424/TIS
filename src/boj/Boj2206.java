package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
https://www.acmicpc.net/problem/2206
 */
public class Boj2206 {
    static int[][] map, visited;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        int result = bfs(new Pair(0, 0, 1, 0));
        System.out.println(result);
    }

    private static int bfs(Pair pair) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(pair);
        visited[pair.x][pair.y] = 0;

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.x == n-1 && now.y == m-1) return now.distance;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] <= now.drill) continue;
                if (map[nx][ny] == 0) {
                    visited[nx][ny] = now.drill;
                    q.offer(new Pair(nx, ny, now.distance + 1, now.drill));
                } else {
                    if (now.drill != 0) continue;
                    visited[nx][ny] = now.drill + 1;
                    q.offer(new Pair(nx, ny, now.distance + 1, now.drill + 1));
                }
            }
        }
        return -1;
    }

    static class Pair {
        int x;
        int y;
        int distance;
        int drill;
        Pair(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.distance = d;
            this.drill = c;
        }
    }
}
