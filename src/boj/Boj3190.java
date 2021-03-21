package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/3190
 */
public class Boj3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][n+1];
        int appCnt = Integer.parseInt(br.readLine());
        for(int i=0; i<appCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 사과가 있는 칸을 1로 초기화
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        List<Pos> list = new ArrayList<>();
        int dLen = Integer.parseInt(br.readLine());
        for(int i=0; i<dLen; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Pos(Integer.parseInt(st.nextToken()), st.nextToken()));
        } // 입력 END

        int result = move(arr, list);
        System.out.println(result);
    }
    public static int move(int[][] board, List<Pos> list) {
        int ret = 0;
        int index = 0;
        // 초기 뱀은 1,1 부터 시작, 몸길이는 1
        SnakePos s = new SnakePos(1,1);
        Queue<SnakePos> q = new LinkedList<>();
        // 꼬리정보는 큐에서 처리
        q.offer(s);
        // 초기 이동값: 오른쪽
        int d = 0;
        // 우 하 좌 상
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        while(true) {
            ret++;
            // 벽이랑 부딪힐경우 return
            if(s.x+dx[d] < 1 || s.x+dx[d] > board.length-1 || s.y+dy[d] < 1 || s.y+dy[d] > board.length-1)
                return ret;
            // 진행방향으로 뱀 이동
            s.x += dx[d];
            s.y += dy[d];
            // 자기 자신과 부딪혔을때 return
            if(board[s.x][s.y] == 2) return ret;
            // 진행 방향에 사과가 없다면 뱀이 이동 후 꼬리 제거
            if(board[s.x][s.y] == 0) {
                // 뱀 이동
                board[s.x][s.y] = 2;
                // 꼬리 추가
                q.offer(new SnakePos(s.x,s.y));
                // ts = 꼬리 정보 SnakePos
                SnakePos ts = q.poll();
                // 꼬리 비우기
                board[ts.x][ts.y] = 0;
            }
            // 사과가 있다면
            else if(board[s.x][s.y] == 1){
                // 뱀 이동
                board[s.x][s.y] = 2;
                // 꼬리 추가
                q.offer(new SnakePos(s.x,s.y));
            }
            // 위의 이동을 하고 방향 전환
            if(ret == list.get(index).time) {
                // 왼쪽
                if(list.get(index).direction.equals("L")) {
                    d = d==0?3:d-1;
                }
                // 오른쪽
                else if(list.get(index).direction.equals("D")){
                    d = (d+1)%4;
                }
                index++;
                if(list.size() == index) {
                    index--;
                }
            }
        }
    }
}
class Pos {
    int time;
    String direction;

    Pos(int t, String d) {
        this.time = t;
        this.direction = d;
    }
}
class SnakePos {
    // 뱀 좌표
    int x;
    int y;
    SnakePos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}