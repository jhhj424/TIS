package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2178
 */
public class Boj2178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        miro = new int[n][m];
        dist = new int[n][m];
        for(int i=0; i<n; i++) {
            String s = sc.next();
            for(int j=0; j<m; j++) {
                miro[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));;
    }
    static int[][] miro;
    static int[][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x,y));
        dist[x][y] = miro[x][y];
        while(!q.isEmpty()) {
            Pair now = q.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(miro[nx][ny] == 0) continue;
                if(dist[nx][ny] != 0) continue;
                q.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[now.x][now.y]+1;
            }
        }

        return dist[n-1][m-1];
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}