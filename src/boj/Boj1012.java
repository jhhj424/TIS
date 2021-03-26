package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1012
 */
public class Boj1012 {
    static int[][] input;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt(); // 테스트케이스 수
        for(int t=0; t<testCaseCnt; t++) {
            m = sc.nextInt(); // 가로
            n = sc.nextInt(); // 세로
            int k = sc.nextInt(); // 배추의 위치의 갯수
            input = new int[m][n];

            // 배추 위치 표시
            for(int i=0; i<k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                input[a][b] = 1;
            }

            int result = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(input[i][j] == 0) continue;
                    dfs(i,j);
                    result++;
                }
            }
            System.out.println(result);
        }
    }
    static void dfs(int a, int b) {
        if(a < 0 || b < 0 || a >= m || b >= n) return;
        if(input[a][b] == 0) return;
        input[a][b] = 0;
        dfs(a+1,b);
        dfs(a-1,b);
        dfs(a,b+1);
        dfs(a,b-1);
    }
}
