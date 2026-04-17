package leetCode.general.String;
// 将1移动到末尾的最大操作次数

public class moveOneV2 {
    public int maxOperations(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int cnt1=0;
        for(int i=0;i<s.length;i++){
            if(s[i]=='1'){
                cnt1++;
            }else if(i>0 && s[i-1]=='1'){
                ans += cnt1;
            }
        }
        return ans;
    }
}
