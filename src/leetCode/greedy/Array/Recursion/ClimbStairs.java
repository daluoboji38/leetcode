package leetCode.greedy.Array.Recursion;

// 爬楼梯
public class ClimbStairs {
    public int climbStairs(int n) {
        /*if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);*/
        int[][] m={
                {1,1},
                {1,0}
        };
        int[][] f0={{1},{0}};
        int[][] fn=powMul(m,n,f0);
        return fn[0][0];
    }

    private int[][] powMul(int[][] a,int n,int[][] f0){
        while(n>0){
            if((n&1)>0) f0=mul(a,f0);
            a=mul(a,a);
            n>>=1;
        }
        return f0;
    }

    // Fibonacci Sequence
    private int[][] mul(int[][] a, int[][] b){
        int[][] c=new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j]==0) continue;
                for (int k = 0; k < b[j].length; k++) {
                    c[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        return c;
    }
}
