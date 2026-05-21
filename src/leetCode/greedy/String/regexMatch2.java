package leetCode.greedy.String;

// 通配符匹配
public class regexMatch2 {

    public boolean isMatch(String s, String p) {
        int pl = p.length(), sl = s.length();
        boolean[][] table = new boolean[pl+1][sl+1];
        table[0][0] = true;

        for (int i = 1; i <= pl; i++) {
            table[i][0]=table[i-1][0] && p.charAt(i-1)=='*';
        }

        for (int i = 1; i <= pl; i++) {
            for(int j=1; j<=sl; j++){
                if (p.charAt(i-1)=='*'){
                    table[i][j]=table[i][j-1] || table[i-1][j];
                } else if(p.charAt(i-1)=='?' || p.charAt(i-1)==s.charAt(j-1)){
                    ;table[i][j]=table[i-1][j-1];
                }
            }
        }
        return table[pl][sl];
    }


}
