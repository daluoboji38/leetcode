package leetCode.general.TDArray;
// 银行中的激光束数量
public class numberOfBeamsV2 {
    public int numberOfBeams(String[] bank) {
        int last = 0,ans = 0;
        for(String s : bank){
            int cnt = (int) s.chars().filter(ch -> ch == '1').count();
            if(cnt != 0){
                ans += cnt*last;
                last = cnt;
            }
        }
        return ans;
    }
}
