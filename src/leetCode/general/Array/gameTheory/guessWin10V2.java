package leetCode.general.Array.gameTheory;

// 求和游戏
public class guessWin10V2 {
    public boolean sumGame(String num) {
        int diff=0,diffQ=0;
        int n=num.length();
        int mid=n>>1;
        char[] str=num.toCharArray();
        for(int i=0;i<mid;i++) {
            if (str[i] == '?') diffQ++;
            else diff += str[i] - '0';
        }
        for(int i=mid;i<n;i++){
            if(str[i]=='?') diffQ--;
            else diff-=str[i]-'0';
        }
        return ((diff<<1)+(diffQ<<3)+diffQ)!=0;
    }
}
