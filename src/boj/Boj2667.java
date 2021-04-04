package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2667
 */
public class Boj2667 {
    static int n, cnt = 0;
    static int[][] arr;
    static boolean[][] visited = new boolean[626][626];
    static ArrayList<Integer> list = new ArrayList<>();

    // 상 하 좌 우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            String s = sc.next();
            for(int j=0; j<n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    cnt = 1;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i: list) {
            System.out.println(i);
        }
    }
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if(!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                dfs(nextX,nextY);
                cnt++;
            }
        }
    }
}
