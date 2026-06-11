package leetCode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 折扣价交易股票的最大利润
// nothing to do with tree structure
public class ZOBOnTree {
    public int maxProfit(int n,int[] present,int[] future,int[][] hierarchy,int budget){
        List<Integer>[] g=new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for(int[] e:hierarchy){
            g[e[0]-1].add(e[1]-1);
        }
        int[][] f0=dfs(0, g, present, future, budget);
        return Arrays.stream(f0[0]).max().getAsInt();
    }

    private int[][] dfs(int x, List<Integer>[] g, int[] present, int[] future, int budget){
        /** caculate the sum of max profit got from the child node y of x
         * for 2D ARRAY f[j][k]
         * 2D array: the sum of max profit
         * j: budget
         * k: 0 for full price, 1 for discount price
         */
        int[][] subF = new int[2][budget+1];
        Arrays.fill(subF[0], Integer.MIN_VALUE/2);
        Arrays.fill(subF[1], Integer.MIN_VALUE/2);
        subF[0][0]=subF[1][0]=0;
        // enmerate all child node jy of x, and update the final value of subF[j][k]
        for(int y:g[x]){
            // fy: max profit of point y, jy: budget limit, k: 0 for full price, 1 for discount price
            int[][] fy = dfs(y, g, present, future, budget);
            // consider as a jy size, fy[j][k] value item
            for(int k=0;k<2;k++){
                int nf[] = new int[budget+1];
                Arrays.fill(nf, Integer.MIN_VALUE/2);
                nf[0]=0;
                for(int jy=0;jy <=budget;jy++){
                    int resY=fy[k][jy];
                    if (resY<0) continue;
                    for(int j=jy;j<=budget;j++){
                        nf[j]=Math.max(nf[j], subF[k][j-jy]+resY);
                    }
                }
                subF[k]=nf;
            }
        }

        // calculate the max profit for x
        int[][] f = new int[2][];
        for(int k=0;k<2;k++){
            f[k]=subF[0].clone();
            int cost=present[x]/(k+1);
            for(int j=cost;j<=budget;j++){
                    // 1st param:parent no buy, 2nd param:parent buy
                    f[k][j]=Math.max(f[k][j], subF[1][j-cost]+future[x]-cost);
                }
            }
        return f;
    }
}
