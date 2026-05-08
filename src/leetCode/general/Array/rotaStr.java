package leetCode.general.Array;

//旋转字符串
public class rotaStr {
    public boolean rotateString(String s, String goal) {
        return (s.length() == goal.length() && (s + s).contains(goal));
    }
}
