package leetCode.general.String;
// 最长公共前缀
public class commonPrefix{
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            prefix = compare(prefix, strs[i]);
            if(prefix.equals("")){
                break;
            }
        }
        return prefix;
    }

    public String compare(String str1, String str2){
        int minLength = Math.min(str1.length(), str2.length());
        for(int i = 0; i < minLength; i++){
            if(str1.charAt(i)!= str2.charAt(i)){
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, minLength);
    }
}
