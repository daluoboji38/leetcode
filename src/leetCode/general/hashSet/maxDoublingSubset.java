package leetCode.general.hashSet;

import java.util.HashSet;
import java.util.Set;

// 子集中元素的最大数量
public class maxDoublingSubset {
    public int maximumLength(int[] nums) {
        Set<Integer> st=new HashSet<>();
        Set<Integer> st2=new HashSet<>();
        int cnt=0;
        for(int num:nums){
            if(num==1)cnt++;
            if(st.contains(num)){
                st2.add(num);
            }else {
                st.add(num);
            }
        }
        int m=st.size();

        int ans=1;
        ans=Math.max(ans,cnt-1 | 1);
        for(int x:st){
            if(x>31622)continue;
            int curr=0;
            int sqrt=(int)Math.sqrt(x);
            if(sqrt*sqrt==x && st2.contains(sqrt)){continue;}
            int y=x*x;
            while(st2.contains(x) && st.contains(y)){
                x=y;y*=y;curr++;
            }
            ans = Math.max(ans, 2 * curr + 1);
            if(ans*2>=m)break;
        }
        return ans;
    }
}
