package leetCode.general.Sort.String;
// 最小回文排列 I
public class minPalindromeV2 {
    public String smallestPalindrome(String s) {
        int l=s.length()/2;
        int[] bucket=new int[26];

        for(int i=0;i<l;i++){
            bucket[s.charAt(i)-'a']++;
        }

        StringBuilder left=new StringBuilder();
        for(int i=0;i<26;i++){
            if(bucket[i]>0){
                left.append(String.valueOf((char)('a'+i)).repeat(bucket[i]));
            }
        }

        String mid=s.length()%2==1?String.valueOf(s.charAt(l)):"";
        String right=new StringBuilder(left).reverse().toString();
        return left.toString()+mid+right;
    }
}
