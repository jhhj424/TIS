package boj;

import java.util.*;

public class Boj18352 {
    static int n,m,k,x;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] d = new int[300001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }
        d[x] = 0;
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i=0; i<graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                if(d[nextNode] == -1) {
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }
        boolean chk = false;
        for(int i=1; i<=n; i++) {
            if(d[i] == k) {
                System.out.println(i);
                chk = true;
            }
        }
        if(!chk) System.out.println(-1);
    }
}