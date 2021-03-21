package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2606
 */
public class Boj2606 {
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean v[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        v = new boolean[n+1];
        bfs(1);
        int cnt = 0;
        for(int i=0; i<=n; i++) {
            if(v[i]) cnt++;
        }
        System.out.println(cnt-1);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        v[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i: graph.get(now)) {
                if(!v[i]) {
                    v[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}