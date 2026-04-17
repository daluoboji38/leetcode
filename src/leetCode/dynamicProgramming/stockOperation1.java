package leetCode.dynamicProgramming;
// 买卖股票的最佳时机
// for loop is quicker than enhanced for loop, but consume more space
public class stockOperation1 {
    public int maxProfit(int[] prices) {
        int ans=0;
        int minPrice=prices[0];
        for(int i=0;i<prices.length;i++){
            ans=Math.max(ans,prices[i]-minPrice);
            minPrice=Math.min(minPrice,prices[i]);
        }
        return ans;
    }
}
