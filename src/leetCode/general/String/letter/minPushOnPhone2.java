package leetCode.general.String.letter;

// // 输入单词需要的最少按键次数 I
public class minPushOnPhone2 {
    public int minimumPushes(String word) {
        int n = word.length();
        int k=n/8;
        return (k*4+(n%8))*(k+1);
    }
}
