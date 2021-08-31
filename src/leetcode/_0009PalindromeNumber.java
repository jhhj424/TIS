package leetcode;

public class _0009PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        return x == reverse(x);
    }

    private int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        return res;
    }


    public int numberOfDigits(int x) {
        int res = 0;
        while (x != 0) {
            res++;
            x /= 10;
        }
        return res;
    }

    private int getDigit(int x, int pos) {
        return (x / (int) Math.pow(10, pos-1)) % 10;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int N = numberOfDigits(x);
        int hi = N;
        int lo = 1;
        while (lo < hi) {
            if (getDigit(x, lo++) != getDigit(x, hi--)) return false;
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}
