package leetCode.slidingWindow;
// 按策略买卖股票的最佳时机
// window is divided into 2, [i-k+1,i-k/2] and [i-k/2+1,i]
public class stockConsecutiveOperation {
    public long maxProfit(int[] prices,int[] strategy,int k) {
        long total = 0, maxSum=0, sum=0;
        for(int i=0;i<prices.length;i++){
            int p=prices[i], s=strategy[i];
            total +=p*s; // profix when no change is made
            sum+=p*(1-s); // the element with index i is added to the right half, strategy change from s to 1

            if(i<k-1){ // first windom is not yet been formed
                if(i>=k/2-1){
                    sum-=prices[i-k/2+1]; // element with index i-k/2+1 move from right half to left half, strategy change from 1 to 0
                }
                continue;
            }

            maxSum = Math.max(maxSum, sum); // element with index i-k/2+1 move from right half to left half, strategy change from 1 to 0
            sum-=prices[i-k/2+1]-prices[i-k+1]*strategy[i-k+1]; // index i-k+1 exit window from left half, strategy change from 0 to strategy[i-k+1]
        }
        return total+maxSum;
    }
}
