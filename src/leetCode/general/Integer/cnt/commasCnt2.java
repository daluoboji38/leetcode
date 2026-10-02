package leetCode.general.Integer.cnt;


// 统计范围内的逗号 II
public class commasCnt2 {
    public long countCommas(long n) {
        long mul=1000,ans=0;
        while(n>=mul){
            ans+=n-mul+1;
            mul*=1000;
        }
        return ans;
    }
}
