package leetCode.general.Array.gameTheory;

// 求和游戏
public class guessWin10 {
    public boolean sumGame(String num) {
        int diff=0,diffQ=0;
        int n=num.length();
        for(int i=0;i<n/2;i++) {
            if (num.charAt(i) == '?') diffQ++;
            else diff += num.charAt(i) - '0';
        }
        for(int i=n/2;i<n;i++){
            if(num.charAt(i)=='?') diffQ--;
            else diff-=num.charAt(i)-'0';
        }
        if(Math.abs(diffQ)%2==1) return true;
        if(diffQ==0&&diff==0) return false;
        if(diffQ==0||diff==0) return true;
        return diffQ * diff >= 0 || diffQ / 2 * 9 != -diff;
    }
}
