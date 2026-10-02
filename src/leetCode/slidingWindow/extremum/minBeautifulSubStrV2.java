package leetCode.slidingWindow.extremum;

// 最短且字典序最小的美丽子字符串
public class minBeautifulSubStrV2 {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int cntOne=0;
        int min = Integer.MAX_VALUE;
        int left =0;

        for(int right=0;right<n;right++){
            if(ch[right]=='1')cntOne++;
            while(cntOne > k){
                if(ch[left]=='1')cntOne--;
                left++;
            }
            while(cntOne==k&&ch[left]=='0')left++;
            if(cntOne==k)min=Math.min(min,right-left+1);
        }
        if(min==Integer.MAX_VALUE)return "";

        String res=null;
        int cnt=0;
        for(int i=0;i<min;i++){
            if(ch[i]=='1')cnt++;
        }
        if(cnt==k){
            res=s.substring(0,min);
        }
        for(int i=min;i<n;i++){
            if(ch[i-min]=='1')cnt--;
            if(ch[i]=='1')cnt++;

            if(cnt==k){
                String cur=s.substring(i-min+1,i+1);
                if(res==null||res.compareTo(cur)>0){
                    res=cur;
                }
            }
        }
        return res;
    }
}
