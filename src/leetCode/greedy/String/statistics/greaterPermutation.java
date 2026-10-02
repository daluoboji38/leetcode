package leetCode.greedy.String.statistics;

// 大于目标字符串的最小字典序排列
public class greaterPermutation {
    public String lexGreaterPermutation(String s, String target) {
        char[] t=target.toCharArray();
        int n=t.length;
        int[] left =new int[26];
        for(int i=0;i<n;i++){
            left[s.charAt(i)-'a']++;
            left[t[i]-'a']--;
        }

        int neg=0;
        int mask=0;
        for(int i=0;i<26;i++){
            if(left[i]<0){
                neg++;
            }else if(left[i]>0){
                mask |= 1<<i;
            }
        }

        for(int i=n-1;i>=0;i--){
            int b=t[i]-'a';
            left[b]++;

            if(left[b]==0){
                neg--;
            }else if(left[b]==1){
                mask |= 1<<b;
            }

            if(neg>0||mask>>(b+1)==0){
                continue;
            }

            mask &= -(1 << (b + 1));
            int j=Integer.numberOfTrailingZeros(mask);
            left[j]--;
            StringBuilder ans=new StringBuilder(target.substring(0,i+1));
            ans.setCharAt(i,(char)('a'+j));

            for(int k=0;k<26;k++){
                ans.repeat('a'+k,left[k]);
            }
            return ans.toString();
        }
        return "";
    }
}
