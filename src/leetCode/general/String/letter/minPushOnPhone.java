package leetCode.general.String.letter;

import java.util.Arrays;

// 输入单词需要的最少按键次数 II
public class minPushOnPhone {
    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        int res = 0;
        for (int i = 25; i >= 0 && cnt[i] > 0; i--) {
            res += ((25-i)/8 + 1) * cnt[i];
        }
        return res;
    }
}
