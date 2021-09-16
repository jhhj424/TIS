package leetcode;


public class _0067AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        addBinary(a, b, a.length() - 1, b.length() - 1, 0, sb);
        return sb.toString();
    }

    private void addBinary(String a, String b, int i, int j, int carry, StringBuilder sb) {
        if (i < 0 && j < 0) {
            sb.append((carry == 0) ? "" : "1");
            return;
        }

        int sum = carry;
        if (i >= 0 && a.charAt(i) == '1') sum++;
        if (j >= 0 && b.charAt(j) == '1') sum++;
        addBinary(a, b, i - 1, j - 1, (sum < 2) ? 0 : 1, sb);

        sb.append((sum % 2 == 0) ? '0' : '1');
    }

}
