package boj;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/8980

4 40
3
1 4 40
2 3 40
3 4 40
80
 */
public class Boj8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 마을의 수
        int c = Integer.parseInt(s[1]); // 트럭의 용량
        int m = Integer.parseInt(br.readLine()); // 보내는 박스 정보의 개수
        Box[] boxes = new Box[m];
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            Box box = new Box(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            boxes[i] = box;
        }
        Arrays.sort(boxes, (b1, b2) -> {
            return b1.end - b2.end;
        });

        for (Box box : boxes) {
            System.out.println(box);
        }

        Truck truck = new Truck(c, 0);
        int city = 1;
        // 박스 개수만큼!
        for (int i = 0; i < m; i++) {
            Box now = boxes[i];
            city = now.start;
            // 박스 내리기
            for (int j = 0; j < m; j++) {
                Box preBox = boxes[j];
                if (preBox.end == city) {
                    preBox.end = -1;
                    truck.deliveryCompleted(preBox.count);
                }
            }
            // 박스 올리기
            int addCount = truck.add(now.count);
            boxes[i].count = addCount;
        }
        while (city < n) {
            // 박스 내리기
            city++;
            for (int i = 0; i < m; i++) {
                Box box = boxes[i];
                if (box.end == city) {
                    box.end = -1;
                    truck.deliveryCompleted(box.count);
                }
            }
        }

        System.out.println(truck.sum);
    }
    static class Box {
        int start;
        int end;
        int count;

        public Box(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "start=" + start +
                    ", end=" + end +
                    ", count=" + count +
                    '}';
        }
    }
    static class Truck {
        int limit;
        int box;
        int sum;

        public Truck(int limit, int box) {
            this.limit = limit;
            this.box = box;
        }

        int add(int b) {
            int count;
            if (box + b > limit) {
                count = limit - box;
                box += count;
            } else {
                count = b;
                box += b;
            }
            return count;
        }

        void deliveryCompleted(int b) {
            box -= b;
            sum += b;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "limit=" + limit +
                    ", box=" + box +
                    ", sum=" + sum +
                    '}';
        }
    }
}
