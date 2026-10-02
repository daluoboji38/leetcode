package leetCode.general.Integer.extreme;

// 两个数字的最大乘积
public class twoDigProduct {
    public int maxproduct(int n){
        int[] cnt=new int[10];
        while (n>0){
            cnt[n%10]++;
            if(cnt[9]==2)return 81;
            n/=10;
        }
        int res=1;
        int r=2;
        for(int i=9;i>=0;i--){
            while(cnt[i]!=0){
                res*=i;
                cnt[i]--;
                r--;
                if(r==0)return res;
            }
        }
        return res;
    }
}
