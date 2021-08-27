import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("..xx.x.",
                                    "x.x.x.."));
    }

    public static int solution(String L1, String L2) {

        int[] cnt = new int[2];
        for (int i = 0; i < L1.length(); i++) {
            if (L1.charAt(i) == 'x') cnt[0]++;
            if (L2.charAt(i) == 'x') cnt[1]++;
        }

        int result = 0;
        for (int i = 0; i < L1.length(); i++) {
            if (cnt[0] != cnt[1]) {
                int c = getAddCount(L1, L2, cnt);
                result += Math.max(cnt[0], cnt[1]) + c;
                break;
            }
            if (L1.charAt(i) == 'x') {
                cnt[0]--;
            }
            if (L2.charAt(i) == 'x') {
                cnt[1]--;
            }
        }

        return result;
    }

    private static int getAddCount(String L1, String L2, int[] cnt) {
        int c = 0;
        if (cnt[0] > cnt[1]) {
            for (int j = 0; j < getFirstIndex(L1); j++) {
                if (L2.charAt(j) == 'x') c++;
            }
        } else {
            for (int j = 0; j < getFirstIndex(L2); j++) {
                if (L1.charAt(j) == 'x') c++;
            }
        }
        return c;
    }

    private static int getFirstIndex(String l1) {
        for (int i = 0; i < l1.length(); i++) {
            if (l1.charAt(i) == 'x') return i;
        }
        return 0;
    }
}
