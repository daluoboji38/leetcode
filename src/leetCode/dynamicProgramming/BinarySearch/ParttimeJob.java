package leetCode.dynamicProgramming.BinarySearch;

import java.util.Arrays;

// 规划兼职工作
public class ParttimeJob {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs=new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] f=new int[n+1];
        for (int i = 0; i < n; i++) {
            int j = search(jobs, i, jobs[i][0]);
            f[i+1] = Math.max(f[i], jobs[i][2] + f[j+1]);
        }
        return f[n];


    }

    private int search(int[][] jobs, int right,int upper){
        int left=-1;
        while (left+1<right) {
            int mid = (right + left) >>>1 ;
            if (jobs[mid][1] <= upper) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
