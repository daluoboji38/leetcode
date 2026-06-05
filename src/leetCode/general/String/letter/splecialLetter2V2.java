package leetCode.general.String.letter;


import java.util.Arrays;

public class splecialLetter2V2 {
    public int numberOfSpecialChars(String word) {
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        int index=0;
        for(byte b:word.getBytes()){
            index++;
            if(b>='a'){
                last[b-'a']=index;
            }else if(first[b-'A']==-1){
                first[b-'A']=index;
            }
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(first[i]!=-1&&last[i]!=-1){
                ans+=last[i]<first[i]?1:0;
            }
        }
        return ans;
    }
}
