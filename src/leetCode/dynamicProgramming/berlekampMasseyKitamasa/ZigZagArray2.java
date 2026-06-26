package leetCode.dynamicProgramming.berlekampMasseyKitamasa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 锯齿形数组的总数 II
public class ZigZagArray2 {
    private static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        //Berlekamp-Massey, Kitamasa
        int[] a=zigZagArraysInit(l,r);
        List<Integer> coef = berlekampMassey(a);
        int k=coef.size();
        int[] c=new int[k];
        for(int i=0;i<k;i++){
            c[i]=coef.get(k-1-i);
        }
        return kitamasa(c,a,n-2);
    }

    private int[] zigZagArraysInit(int l,int r){
        int k=r-l+1;

        int[] a=new int[k*2],b=new int[k*2],res=new int[k*2];

        for(int v=1;v<k;v++) a[v]=v;

        for(int i=0;i<a.length;i++){
            int s=0;
            b[0]=0;
            for (int v = 1; v < k; v++) {
                s += a[k - v] - MOD;    // deduct MOD first
                s += MOD & (s >> 31); // add MOD if s is negative. MOD & 0xffffffff=MOD
                b[v] = s;
                res[i] += s - MOD;
                res[i] += MOD & (res[i] >> 31);
            }
            res[i] = s*2 - MOD;
            res[i] += MOD & (res[i] >> 31);
            int[] t = a;
            a = b;
            b = t;
        }
        return res;
    }

    private List<Integer> berlekampMassey(int[] a) {
        List<Integer> coef = new ArrayList<>(); // the shortest recurrence coefficients currently maintained
        List<Integer> preC = new ArrayList<>(); // the old recurrence relation saved at the previous error occurrence
        int preI=-1; // index where the previous error occurred
        int preD=0; // error value
        for (int i = 0; i < a.length; i++) {
            long d = a[i];
            for(int j=0;j<coef.size();j++){
                d=(d-(long)coef.get(j)*a[i-1-j])%MOD;
            }
            if(d==0){
                continue;
            }

            if(preI<0){
                coef=new ArrayList<>(Collections.nCopies(i+1,0));
                preI=i;
                preD=(int)d;
                continue;
            }

            int bias=i-preI; // interval between two errors
            int oldLen = coef.size();
            int newLen=bias+preC.size();
            List<Integer> tmp=null;
            if(newLen>oldLen){
                tmp=new ArrayList<>(coef);
                coef.addAll(Collections.nCopies(newLen-oldLen, 0));
            }

            long delta=d*pow(preD,MOD-2)%MOD; // multiplicative inverse of preD under MOD
            coef.set(bias-1,(int)((coef.get(bias-1)+delta)%MOD));
            for(int j=0;j<preC.size();j++){
                coef.set(j+bias,(int)((coef.get(j+bias)-delta*preC.get(j))%MOD));
            }

            if(newLen>oldLen){
                preC=tmp;
                preI=i;
                preD=(int)d;
            }
        }
        return coef;
    }

    private int kitamasa(int[] coef,int[] a,long n){
        if(n<a.length){
            return a[(int)n]%MOD;
        }

        int k=coef.length;
        if(k==0) return 0;
        if(k==1) return (int)((long)a[0]*pow(coef[0],n)%MOD);

        int[] resC=new int[k];
        int[] c=new int[k];
        resC[0]=c[1]=1;
        for(;n>0;n/=2){
            if(n%2==1){
                resC=compose(coef,c,resC);
            }
            c=compose(coef,c,c.clone());
        }

        long ans=0;
        for(int i=0;i<k;i++){
            ans=(ans+(long)resC[i]*a[i])%MOD;
        }
        return (int)((ans+MOD)%MOD);

    }

    private int[] compose(int[] coef,int[] a,int[] b){
        int k=a.length;
        int[] c=new int[k];
        for(int v:a){
            for(int j=0;j<k;j++){
                c[j]=(int)((c[j]+(long)v*b[j])%MOD);
            }
            // avoid i+j>k
            long bk1=b[k-1];
            for(int i=k-1;i>0;i--){
                b[i]=(int)((b[i-1]+bk1*coef[i])%MOD);
            }
            b[0]=(int)(bk1*coef[0]%MOD);
        }
        return c;
    }

    private int pow(long x,long n){
        long res=1;
        for(;n>0;n/=2){
            if(n%2==1){
                res=res*x%MOD;
            }
            x=x*x%MOD;
        }
        return (int)res;
    }
}
