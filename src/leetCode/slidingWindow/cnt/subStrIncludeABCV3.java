package leetCode.slidingWindow.cnt;

public class subStrIncludeABCV3 {
    public int numberOfSubstrings(String s) {
        int cnt=0,n=s.length(),ans=0;
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        for(int l=0,r=0;r<n;r++){
            if(map[arr[r]]++==0)cnt++;
            while(cnt==3){
                if(--map[arr[l++]]==0)cnt--;
            }
            ans+=l;
        }
        return ans;
    }
}
