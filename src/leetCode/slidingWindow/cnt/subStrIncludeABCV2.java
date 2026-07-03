package leetCode.slidingWindow.cnt;

public class subStrIncludeABCV2 {
    public int numberOfSubstrings(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int ans=0;
        int[] cnt = new int[3];
        for(int i=0;i<n;i++){
            cnt[arr[i]-'a']=i+1;
            ans+=Math.min(cnt[0],Math.min(cnt[1],cnt[2]));
        }
        return ans;
    }
}
