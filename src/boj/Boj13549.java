package boj;

import java.util.*;

public class Boj13549 {
    public static void main(String[] args) {
        int[] dist = new int[100001];
        int[] next = new int[3];
        Arrays.fill(dist, -1); // 거리를 모두 -1로 초기화

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수빈이 위치
        int k = sc.nextInt(); // 동생위치 : 목적지

        dist[n] = 0;

        bfs(dist, next, n);

        System.out.println(dist[k]);
    }

    private static void bfs(int[] dist, int[] next, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()) {
            int now = queue.poll();

            next[0] = now * 2;
            next[1] = now - 1;
            next[2] = now + 1;

            for(int i=0; i<3; i++) {
                if(next[i] < 0 || next[i] > 100000)
                    continue;
                if(dist[next[i]] > -1)
                    continue;
                if(i == 0) // 시간 0초 증가
                    dist[next[i]] = dist[now];
                else // 시간 1초 증가
                    dist[next[i]] = dist[now] + 1;

                queue.offer(next[i]);
            }
        }
    }
}