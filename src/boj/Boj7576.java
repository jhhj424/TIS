package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/7576
 */
public class Boj7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] input = new int[n][m];
        int[][] dist = new int[n][m];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int in = sc.nextInt();
                input[i][j] = in;
                if(in == 0) {
                    dist[i][j] = -1;
                } else if(in == 1) {
                    q.offer(new Pair(i,j));
                }
            }
        }

        while(!q.isEmpty()) {
            Pair now = q.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[now.x][now.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);

    }
}
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}