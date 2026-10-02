package leetCode.general.Enumerate.String;

// 最少得分子序列
public class minSubSeqScore {
    public int minimumScore(String S, String T) {
        char[] s=S.toCharArray();
        char[] t=T.toCharArray();
        int n=s.length,m=t.length;
        
        int[] suf=new int[n+1];
        suf[n]=m;
        int j=m-1;
        for(int i=n-1;i>=0;i--){
            if(s[i]==t[j]) j--;
            if(j<0) return 0;
            suf[i]=j+1;
        }

        int ans=suf[0];
        j=0;
        for(int i=0;i<n;i++){
            if(s[i]==t[j]) j++;
            ans=Math.min(ans,suf[i+1]-j);
        }
        return ans;
    }
}
