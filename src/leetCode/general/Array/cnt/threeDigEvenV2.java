package leetCode.general.Array.cnt;
// 不同三位偶数的数目
public class threeDigEvenV2 {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for(int d: digits){
            cnt[d]++;
        }
        int res=0;
        for(int i=100;i<1000;i+=100){
            if(cnt[i/100]==0) continue;
            cnt[i/100]--;
            for(int j=0;j<100;j+=10){
                if(cnt[j/10]==0) continue;
                cnt[j/10]--;
                for(int k=0;k<9;k+=2){
                    if(cnt[k]>0) res++;
                }
                cnt[j/10]++;
            }
            cnt[i/100]++;
        }
        return res;
    }
}
