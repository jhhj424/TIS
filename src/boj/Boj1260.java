package boj;

import java.util.*;

/*
https://www.acmicpc.net/problem/1260
 */
public class Boj1260 {
    static int n,m,v;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList());
        }
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=0; i<=n; i++) {
            Collections.sort(graph.get(i));
        }
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
    }
    static void dfs(int start) {
        System.out.print(start +" ");
        visited[start] = true;
        for(int i: graph.get(start)) {
            if(!visited[i]) dfs(i);
        }
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for(int i: graph.get(now)) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
