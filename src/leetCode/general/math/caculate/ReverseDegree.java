package leetCode.general.math.caculate;

// 字符串的反转度
public class ReverseDegree {
    public int reverseDegree(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=(123-s.charAt(i))*(i+1);
        }
        return ans;
    }
}
