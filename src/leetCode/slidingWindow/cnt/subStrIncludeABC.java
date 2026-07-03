package leetCode.slidingWindow.cnt;

// 包含所有三种字符的子字符串数目

public class subStrIncludeABC {
    public int numberOfSubstrings(String s) {
        char[] arr = s.toCharArray();
        int[] cnt = new int[3];
        int ans=0;
        int left =0;
        for(char c:arr){
            cnt[c-'a']++;
            while(cnt[0]>0&&cnt[1]>0&&cnt[2]>0){
                cnt[arr[left]-'a']--;
                left++;
            }
            ans+=left;
        }
        return ans;
    }
}
