package leetCode.slidingWindow.find;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 滑动窗口中位数
class LazyHeap extends PriorityQueue<Integer> {
    private final Map<Integer, Integer> removeCnt=new HashMap<>();
    private int size=0;

    public LazyHeap(Comparator<Integer> comparator){
        super(comparator);
    }

    public int size(){
        return size;
    }

    public void remove(int x){
        removeCnt.merge(x,1,Integer::sum);
        size--;
    }

    public void applyRemove(){
        while(removeCnt.getOrDefault(peek(),0)>0){
            removeCnt.merge(poll(),-1,Integer::sum);
        }
    }

    public int top(){
        applyRemove();
        return peek();
    }

    public int pop(){
        applyRemove();
        size--;
        return poll();
    }

    public void push(int x){
        offer(x);
        size++;
    }

    public int pushPop(int x){
        if(size>0 && comparator().compare(x,top())>0){
            offer(x);
            return poll();
        }
        return x;
    }

}

public class findMedianInWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        LazyHeap left=new LazyHeap((a,b)->Integer.compare(b,a));// max heap, max out
        LazyHeap right=new LazyHeap(Integer::compare);

        for(int i=0;i<n;i++){
            int in=nums[i];
            if(left.size()==right.size()){
                left.push(right.pushPop(in));
            }else{
                right.push(left.pushPop(in));
            }

            int l=i+1-k;
            if(l<0)continue;

            if(k%2>0){
                ans[l]=left.top();
            }else{
                ans[l]=((long)left.top()+ right.top())/2.0;
            }

            int out=nums[l];
            if(out<= left.top()){
                left.remove(out);
                if(left.size()< right.size())left.push(right.pop());
            }else{
                right.remove(out);
                if(left.size()> right.size()+1)right.push(left.pop());
            }
        }
        return ans;
    }
}
