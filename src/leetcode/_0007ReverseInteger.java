package leetcode;

public class _0007ReverseInteger {
    static int reverse(int input) {
        int result = 0;
        while (input != 0) {
            int pop = input % 10;
            input /= 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 120;

        System.out.println(reverse(x));
    }
}
