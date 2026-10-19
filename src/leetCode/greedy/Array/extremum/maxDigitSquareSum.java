package leetCode.greedy.Array.extremum;

// 数位平方和的最大值
public class maxDigitSquareSum {
    public String maxSumOfSquares(int num, int sum) {
        if(sum/9>=num && sum%9!=0)return "";
        StringBuilder sb=new StringBuilder();
        while(sum>0){
            int digit= Math.min(sum, 9);
            sb.append(digit);
            sum-=digit;
        }
        int need=num-sb.length();
        sb.append("0".repeat(need));
        return sb.toString();
    }
}
