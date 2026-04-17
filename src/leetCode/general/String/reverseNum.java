package leetCode.general.String;
// 整数反转
public class reverseNum {
    public int reverse(int x) {
        int rev = 0;
        String str = String.valueOf(x);
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            rev = -reverseString(str);
        }else {
            rev = reverseString(str);
        }
        return rev;
    }

    public int reverseString(String s) {
        char[] arr = s.toCharArray();
            for(int i=0;i<arr.length/2;i++){
                char temp = arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = temp;
            }
            String str = new String(arr);
            long res = Long.parseLong(str);
            int res2;
            if(res > (1L <<31)-1) return 0;
            else res2 = (int)res;
        return res2;
    }

}
