package leetCode.general.Array.sort;

public class insertIntervalV2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start=newInterval[0],end=newInterval[1];
        int[] insert=new int[2];
        int n=intervals.length;

        if(intervals.length==0){return new int[][]{newInterval};}

        if(newInterval[0]>intervals[n-1][1]){
            int[][] res=new int[n+1][2];
            System.arraycopy(intervals, 0, res, 0, n);
            res[n]=newInterval;
            return res;
        }else if(newInterval[1]<intervals[0][0]){
            int[][] res=new int[n+1][2];
            System.arraycopy(intervals, 0, res, 1, n);
            res[0]=newInterval;
            return res;
        }

        int N=0,l=0;
        for(int i=0;i<n;i++){
            if(start<intervals[i][0]) {
                l = i;
                insert[0] = start;
                break;
            }else if(start>=intervals[i][0] && start<=intervals[i][1]){
                l=i;
                insert[0] = intervals[i][0];
                break;
            }
            N++;
        }
        int r=0;
        for(int i=n-1;i>=0;i--){
            if(end>intervals[i][1]) {
                r = i;
                insert[1] = end;
                break;
            }else if(end>=intervals[i][0] && end<=intervals[i][1]){
                r=i;
                insert[1] = intervals[i][1];
                break;
            }
            N++;
        }
        int[][] res=new int[N+1][2];
        System.arraycopy(intervals, 0, res, 0, l);
        System.arraycopy(intervals, r+1, res, l+1, N-l);
        res[l]=insert;
        return res;
    }
}
