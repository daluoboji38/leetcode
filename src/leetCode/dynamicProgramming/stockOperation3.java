package leetCode.dynamicProgramming;
// 买卖股票的最佳时机3
public class stockOperation3 {
    public int maxProfit(int[] prices) {
        int min =prices[0];
        int[] max = new int[2];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                if(i>1 && prices[i-1]>min) compare(max,prices[i-1]-min);
                min=prices[i];
            }
        }
        if(prices[prices.length-1]>min) compare(max,prices[prices.length-1]-min);
        return max[0]+max[1];
    }

    private void compare(int[] max,int p){
        if(p>max[0]){
            max[1] =max[0];
            max[0] =p;
        }else if(p>max[1]){
            max[1] =p;
        }
    }
}
