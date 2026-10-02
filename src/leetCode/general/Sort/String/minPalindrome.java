package leetCode.general.Sort.String;
// 最小回文排列 I
public class minPalindrome {
    public String smallestPalindrome(String s) {
        int[] cnt=new int[128];
        char[] arr=s.toCharArray();
        int n=arr.length;
        for(int i=0;i<n/2;i++) cnt[arr[i]]++;
        char[] ans=new char[n];
        int i=0;
        for(int j=97;j<=122;j++){
            for(int k=0;k<cnt[j];k++) {
                ans[i]= (char) j;
                ans[n-1-i]= (char) j;
                i++;
            }
        }
        if(n%2==1) ans[i]=arr[n/2];
        return new String(ans);
    }
}
