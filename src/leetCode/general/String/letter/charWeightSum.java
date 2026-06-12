package leetCode.general.String.letter;

// 带权单词映射
public class charWeightSum {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                sum+=weights[c-'a'];
            }
            sb.append((char)(122-sum%26));
        }
        return sb.toString();
    }
}
