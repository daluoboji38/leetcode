package leetCode.backtrack.Matrix;

public class MSearchWordV2 {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int[] cnt = new int[128];
        char[] cs = word.toCharArray();
        int[] boardCnt = new int[128];
        for(char[] row: board){
            for(char c: row){
                boardCnt[c]++;
            }
        }
        for(char c: cs){
            if(++cnt[c]>boardCnt[c])return false;
        }

        if(boardCnt[cs[word.length()-1]]<boardCnt[cs[0]]){
            cs=new StringBuilder(word).reverse().toString().toCharArray();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(i,j,0,board,cs))return true;
            }
        }
        return false;
    }

    public boolean dfs(int i,int j,int k,char[][] board,char[] cs){
        if(board[i][j]!=cs[k])return false;
        if(k==cs.length-1)return true;

        board[i][j] = 0;
        for(int[] dir:dir){
            int x = i + dir[0], y = j + dir[1];
            if(x>=0&&x<board.length&&y>=0&&y<board[0].length
                    &&dfs(x,y,k+1,board,cs))return true;
        }
        board[i][j] = cs[k];
        return false;
    }
}
