package leetCode.general.String;

// 长度为3的不同回文子序列
public class palindromicThree {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int res=0;
        int[] first = new int[26];
        int[] last = new int[26];
        for(int i=0;i<26;i++){
            first[i]=-1;
            last[i]=-1;
        }
        for(int i=0;i<n;i++){
            int c = s.charAt(i) - 'a';
            if(first[c] ==-1){
                first[c]=i;
            }else{
                last[c]=i;
            }
        }
        for(int i=0;i<26;i++){
            if (last[i] !=-1 && last[i]-first[i]>=2){
                res+=uniqueAZ(s.substring(first[i]+1,last[i]));
            }
        }
        return res;
    }

    private int uniqueAZ(String s) {
        int mask=0;
        for(char c:s.toCharArray()){
            mask |= 1<<(c-'a');
        }
        return Integer.bitCount(mask);
    }
}
