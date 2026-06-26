package leetCode.dynamicProgramming.Array;

import java.util.Arrays;

public class ZigZagArrayV2 {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int k=r-l+1;
        int[] a=new int[k],b=new int[k];// a store f0[v],b store next round f0[v] temporarily

        for(int v=1;v<k;v++) a[v]=v;

        for(int i=2;i<n;i++) {
            int s = 0;
            b[0] = 0;
            for (int v = 1; v < k; v++) {
                s += a[k - v] - MOD;    // deduct MOD first
                s += MOD & (s >> 31); // add MOD if s is negative. MOD & 0xffffffff=MOD
                b[v] = s;
            }
            int[] t = a;
            a = b;
            b = t;
        }

            int ans=0;
            for(int v=0;v<k;v++) {
                ans+=a[v]-MOD;
                ans+=MOD & (ans>>31);
            }
            ans<<=1;
            ans-=MOD & ~((ans-MOD)>>31);
            return ans;
        }

    }

