package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
https://www.acmicpc.net/problem/7562
 */
public class Boj7562 {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            solved();
        }
    }

    private static void solved() throws IOException {
        int l = Integer.parseInt(br.readLine());
        int[][] map = new int[l][l];
        boolean[][] visited = new boolean[l][l];
        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        Pair start = new Pair(x, y);

        // 목표 위치
        line = br.readLine().split(" ");
        x = Integer.parseInt(line[0]);
        y = Integer.parseInt(line[1]);

        // 나이트가 이동할 수 있는 거리
        int[] dx = {-2,-1,2,1,2,1,-2,-1};
        int[] dy = {1,2,1,2,-1,-2,-1,-2};

        Queue<Pair> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                if (visited[nx][ny]) continue;

                q.offer(new Pair(nx, ny));
                visited[nx][ny] = true;
                map[nx][ny] = map[now.x][now.y] + 1;
            }
        }

        System.out.println(map[x][y]);
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
