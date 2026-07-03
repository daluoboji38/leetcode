package leetCode.slidingWindow.match;

// 最小覆盖子串
public class MinCoveredArr {
    public String minWindow(String s, String t) {
        int diff[] = new int[128];
        int kinds=0;
        for(char c:t.toCharArray()){
            if(diff[c]==0) kinds++;
            diff[c]--;
        }

        char[] ss = s.toCharArray();
        int m=ss.length;
        int ansleft=-1;
        int ansright=m;
        int getCnt=0;
        int left =0;
        for(int right=0;right<m;right++){
            char c = ss[right];
            diff[c]++;
            if(diff[c]==0) getCnt++;

            while(getCnt==kinds){
                if(right-left<ansright-ansleft){
                    ansleft=left;
                    ansright=right;
                }

                char x=ss[left];
                if(diff[x]==0) getCnt--;
                diff[x]--;
                left++;
            }
        }
        return ansleft==-1?"":s.substring(ansleft,ansright+1);
    }
}
