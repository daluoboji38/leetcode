package leetCode.greedy.binary;

// 操作后最大活跃区段数 I
public class segCntAfterOperationV2 {
    public int maxActiveSectionsAfterTrade(String S) {
        char[] s=S.toCharArray();
        int total1=0;
        int mx=0;
        int pre0=Integer.MIN_VALUE;
        int cnt=0;
        for(int i=0;i<s.length;i++){
            cnt++;
            if(i==s.length-1 || s[i]!=s[i+1]){
                if(s[i]=='1'){
                    total1+=cnt;
                }else{
                    mx=Math.max(mx,pre0+cnt);
                    pre0=cnt;
                }
                cnt=0;
            }
        }
        return total1+mx;
    }
}
