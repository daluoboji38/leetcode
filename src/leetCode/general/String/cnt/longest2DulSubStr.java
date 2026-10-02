package leetCode.general.String.cnt;

// 每个字符最多出现两次的最长子字符串
public class longest2DulSubStr {
    public int maximumLengthSubstring(String s) {
        int[] cnt = new int[128];
        int ans=0;
        for(int left=0,right=0;right<s.length();right++){
            int v=++cnt[s.charAt(right)];
            while(v>2){
                cnt[s.charAt(left)]--;
                if(s.charAt(left)==s.charAt(right))v--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
