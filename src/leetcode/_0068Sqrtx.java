package leetcode;


public class _0068Sqrtx {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

//    public int mySqrt(int x) {
//        long r = x;
//        while (r*r > x)
//            r = (r + x/r) / 2;
//        return (int) r;
//    }
}
