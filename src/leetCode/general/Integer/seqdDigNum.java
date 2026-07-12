package leetCode.general.Integer;

import java.util.ArrayList;
import java.util.List;

// 顺次数
public class seqdDigNum {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int x0=12;
        int pow10 = 10;
        for(int len=2;x0<=high;len++){
            pow10 *= 10;
            int x=x0;
            for(int i=len;i<=9&&x<=high;i++){
                if(x>=low)ans.add(x);
                x=x*10+i+1-(i+1-len)*pow10;
            }
            x0=x0*10+len+1;
        }
        return ans;
    }
}
