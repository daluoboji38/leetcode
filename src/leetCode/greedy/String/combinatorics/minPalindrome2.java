package leetCode.greedy.String.combinatorics;

// 最小回文排列 II
//组合数学
public class minPalindrome2 {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int m=n/2;

        int[] total = new int[26];
        for(int i=0;i<m;i++) total[s.charAt(i)-'a']++;

        int[] cnt=new int[26];
        long perm=1;
        int i=m-1;
        int j=25;

        // count backward
        for(;i>=0 && perm<k;i--){
            while(cnt[j]==total[j])j--;
            cnt[j]++;
            perm=perm*(m-i)/cnt[j];
        }

        if(perm<k) return "";

        StringBuilder ans = new StringBuilder(n);
        for(int ch=0;ch<=j;ch++){
            ans.repeat('a'+ch,total[ch]-cnt[ch]);
        }

        // trial filling method
        int j0=j;
        for(i++;i<m;i++){
            for(j=j0;j<26;j++){
                if(cnt[j]==0)continue;
                // Suppose we fill in the letter j. Derive p backwards using the formula perm=perm*(m-i)/cnt[j];
                long p=perm*cnt[j]/(m-i);
                if(p>=k){
                    ans.append((char)('a'+j));
                    cnt[j]--;
                    perm=p;
                    break;
                }
                k-=p;
            }
        }

        StringBuilder rev = new StringBuilder(ans).reverse();
        if(n%2>0){
            ans.append(s.charAt(n/2));
        }
        return ans.append(rev).toString();
    }
}
