package leetCode.greedy.String.extreme;

// 不重叠回文子字符串的最大数目
public class NonOverlapPalindromesV2 {
    public int maxPalindromes(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        for(int i=0;i<=n-k;){
            if(isPalindrome(s,i,i+k-1)){
                ans++;
                i+=k;
            }else if(i<n-k && isPalindrome(s,i,i+k)){
                ans++;
                i+=k+1;
            }else{
                i++;
            }
        }
        return ans;
    }

    private boolean isPalindrome(char[] s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
