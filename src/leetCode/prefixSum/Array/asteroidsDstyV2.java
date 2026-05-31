package leetCode.prefixSum.Array;

import java.util.Arrays;

public class asteroidsDstyV2 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int mx=0;
        for(int x:asteroids){
            mx=Math.max(mx,x);
        }

        int maxWidth = 32-Integer.numberOfLeadingZeros(mx);
        long[] sum = new long[maxWidth];
        int[] mn = new int[maxWidth];
        Arrays.fill(mn,Integer.MAX_VALUE);

        for(int x:asteroids){
            int i = 31-Integer.numberOfLeadingZeros(x);
            sum[i]+=x;
            mn[i]=Math.min(mn[i],x);
        }

        long m=mass;
        for(int i=0;i<maxWidth;i++){
            if(mn[i]==Integer.MAX_VALUE){
                continue;
            }
            if(m<mn[i]){
                return false;
            }
            m+=sum[i];
        }
        return true;
    }
}
