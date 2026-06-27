package leetCode.dynamicProgramming.String;

// 编辑距离
public class wordConversion {
    public int minDistance(String word1, String word2) {
        char[] t=word2.toCharArray();
        int m=t.length;
        int[] f=new int[m+1];
        for(int j=0;j<m;j++){
            f[j+1]=j+1;
        }
        for(char x:word1.toCharArray()){
            int pre=f[0];
            f[0]++;
            for(int j=0;j<m;j++){
                int temp=f[j+1];
                f[j+1]=x==t[j]?pre:Math.min(f[j+1],Math.min(f[j],pre))+1;
                pre=temp;
            }
        }
        return f[m];
    }
}
