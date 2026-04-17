package leetCode.binarySearch;
// 同时运行N台电脑的最长时间
// to run x minutes simultaneously on n computers, the necessary and sufficient condition is that n⋅x≤sum.

public class runPCsimultaneously {
    public long maxRunTime(int n, int[] batteries) {
        long tot =0;
        for(int b:batteries){
            tot+=b;
        }
        long l=0;
        long r=tot/n +1;
        while(l+1<r){
            long x= l+(r-l)/2;
            long sum=0;
            for(int b:batteries){
                sum+=Math.min(b,x);
            }
            if(sum>=n*x){
                l=x;
            }else{
                r=x;
            }
        }
        return l;
    }
}
