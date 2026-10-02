package leetCode.greedy.binary;

// 操作后最大活跃区段数 I
public class segCntAfterOperation {
    public int maxActiveSectionsAfterTrade(String s) {
        s='1'+s+'1';
        int n=s.length();
        char[] a=s.toCharArray();
        int[] ai=new int[n];
        int cnt=1,len=0,flag=1,ans=0;
        for(int i=0;i<n-1;i++){
            if(a[i]==a[i+1]){
                cnt++;
            }else{
                ai[len++]=cnt;
                if(flag==1)ans+=cnt;
                flag*=-1;
                cnt=1;
            }
        }
        ai[len++]=cnt;
        if(flag==1)ans+=cnt;

        if(len<=3){
            return ans-2;
        }else{
            int diff=ai[1]+ai[3],md=diff;
            for(int i=0;i<=len-7;i+=2){
                diff+=ai[i+5]-ai[i+1];
                md=Math.max(md,diff);

            }
            return ans-2+md;
        }
    }
}
