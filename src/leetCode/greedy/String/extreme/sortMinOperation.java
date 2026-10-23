package leetCode.greedy.String.extreme;

// 将一个字符串排序的最小操作次数
public class sortMinOperation {
    public int minOperations(String S) {
        char[] s=S.toCharArray();
        int n=s.length;

        boolean sorted=true;
        for(int i=1;i<n;i++){
            if(s[i-1]>s[i]){
                sorted=false;
                break;
            }
        }
        if(sorted){return 0;}
        if(n==2){return -1;}

        char mn=s[0];
        char mx=s[0];
        for(char c:s){
            mn=(char)Math.min(mn,c);
            mx=(char)Math.max(mx,c);
        }

        if(s[0]==mn || s[n-1]==mx){return 1;}
        for(int i=1;i<n-1;i++){
            if(s[i]==mn || s[i]==mx){return 2;}
        }
        return 3;
    }
}
