package leetCode.general.Integer.cnt;

// 统计范围内的逗号
public class commasCnt {
    public int countCommas(int n) {
        return n>999?n-999:0;
    }
}
