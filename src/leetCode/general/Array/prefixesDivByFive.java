package leetCode.general.Array;

import java.util.ArrayList;
import java.util.List;

// 可被5整除的二进制前缀
public class prefixesDivByFive {
    public List<Boolean> prefixesDivBy5(int[] nums){
        List<Boolean> result = new ArrayList<>();
        int prefix = 0;
        for(int num : nums){
            prefix = (prefix * 2 + num) % 5;
            result.add(prefix == 0);
        }
        return result;
    }
}
