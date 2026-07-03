package leetCode.general.Array.cnt;

// 作为子字符串出现在单词中的字符串数目
public class subStrCnt {
    public int numOfStrings(String[] patterns, String word) {

        int cnt = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                cnt++;
            }
        }
        return cnt;
    }
}
