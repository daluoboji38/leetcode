package leetCode.general.String.letter;

public class specialLetterV2 {
    public int numberOfSpecialChars(String word) {
        int[] sum=new int[52];
        char[] arr=word.toCharArray();
        for(char c:arr){
            if(c>='A'&&c<='Z'){
                sum[c-'A']++;
            }else if(c>='a'&&c<='z'){
                sum[c-'a'+26]++;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(sum[i]>0&&sum[i+26]>0){
                count++;
            }
        }
        return count;
    }
}
