package leetCode.binarySearch;

// 两个最好的不重叠活动

import java.util.Arrays;

public class twoConflictFreeEvent {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // order ascending by end time
        int ans =0;
        int size=0;
        for (int[] e: events){
            int i=search(events,size,e[0]);
            int value=e[2];
            if(i>=0) {
                ans = Math.max(ans, value + events[i][2]);
            }else{
                ans = Math.max(ans, value);
            }
            // maintain a monotonic stack only add event if the end time is greater and the value is also greater than the last event in the stack
            if(size==0 || value>events[size-1][2]) {
                events[size++] = e;
            }
        }
        return ans;
    }

    // return the last i of st[i][1] < target
    private int search(int[][] st,int right, int target){
        int left=-1;
        while(left+1<right){
            int mid = (left + right)/2;
            if(st[mid][1]<target) left=mid;
            else right=mid;
        }
        return left;
        }

}
