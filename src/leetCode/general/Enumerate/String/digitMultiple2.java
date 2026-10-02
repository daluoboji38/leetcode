package leetCode.general.Enumerate.String;

// 最小可整除数位乘积 II
// enumerate from right to left
public class digitMultiple2 {
    public String smallestNumber(String num ,long t){
        long tmp=t;
        for(int i=9;i>1;i--){
            while(tmp%i==0){
                tmp/=i;
            }
        }
        if(tmp>1)return "-1";

        char[] s=num.toCharArray();
        int n=s.length;
        long[] leftT=new long[n+1];
        leftT[0]=t;
        int i0=n-1;
        for(int i=0;i<n;i++){
            if(s[i]=='0'){
                i0=i;
                break;
            }
            leftT[i+1]=leftT[i]/gcd(leftT[i],s[i]-'0');
        }
        if(leftT[n]==1)return num;

        // Assume the answer is the same length as num.
        for(int i=i0;i>=0;i--){
            while(++s[i]<='9'){
                long tt=leftT[i]/gcd(leftT[i],s[i]-'0');
                int k=9;
                for(int j=n-1;j>i;j--){
                    while(tt%k!=0){
                        k--;
                    }
                    tt/=k;
                    s[j]=(char)('0'+k);
                }
                if(tt==1)return new String(s);
            }
        }

        // answer is longer than num
        StringBuilder ans=new StringBuilder();
        for(int i=9;i>1;i--){
            while(t%i==0){
                ans.append((char)('0'+i));
                t/=i;
            }
        }
        while(ans.length()<=n){
            ans.append('1');
        }
        return ans.reverse().toString();
    }

    private long gcd(long a,long b){
        while(a!=0){
            long tmp=a;
            a=b%a;
            b=tmp;
        }
        return b;
    }
}
