package leetCode.general.math;

public class BinarySumV2 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        int max=Math.max(i+1,j+1);
        int k=max;
        char[] chs = new char[max+1];
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? a.charAt(i--) - '0' : 0;
            int y = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            chs[k--] = (char) (sum % 2 + '0');
            carry = sum / 2;
        }
        return new String(chs, k+1, max-k);
    }
}
