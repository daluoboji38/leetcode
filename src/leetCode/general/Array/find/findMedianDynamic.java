package leetCode.general.Array.find;

import java.util.PriorityQueue;

// 数据流的中位数
public class findMedianDynamic {
    private final PriorityQueue<Integer> left = new PriorityQueue<>((a,b)->b-a);// max heap
    private final PriorityQueue<Integer> right = new PriorityQueue<>();// min heap
    public void addNum(int num) {
        if(left.size()==right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else{
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if(left.size()>right.size()){
            return left.peek();
        }
        return (left.peek()+right.peek())/2.0;
    }
}
