package leetCode.slidingWindow.extremum;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 滑动窗口最大值
public class MaxInSlide {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans=new int[n-k+1];
        Deque<Integer> q=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!q.isEmpty()&& nums[q.getLast()]<=nums[i]){
                q.removeLast(); // maintain decreasing order
            }
            q.addLast(i);

            int left=i-k+1;
            if(q.getFirst()<left)q.removeFirst();

            if(left>=0)ans[left]=nums[q.getFirst()];
        }
        return ans;
    }
}
