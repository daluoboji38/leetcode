package leetCode.twoPointer.String;

// 不同字符的最小子序列
// bitwise operations format
public class allCharSubseqV2 {
    public String smallestSubsequence(String s) {
        char[] arr = s.toCharArray();
        int[] left =new int[26];
        for(char c:arr){
            left[c-'a']++;
        }

        char[] stack = new char[arr.length];
        int head=-1;
        int exist=0;
        for(char c:arr){
            int pos=c-'a';
            left[pos]--;
            if((exist & (1<<pos))!=0){continue;}
            while(head>=0 && stack[head]>=c && left[stack[head]-'a']>0){
                exist &=(~(1<<(stack[head]-'a')));
                head--;
            }
            stack[++head]=c;
            exist |=(1<<pos);
        }
        return new String(stack,0,head+1);
    }
}
