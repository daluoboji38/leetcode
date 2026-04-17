package leetCode.general.Array;

// 找出字符串中第一个匹配项的下标

public class matchSubStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty() || haystack.isEmpty() || needle.length() > haystack.length() || !haystack.contains(needle)){
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
