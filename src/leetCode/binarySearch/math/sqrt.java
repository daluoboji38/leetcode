package leetCode.binarySearch.math;

// x 的平方根
// closed interval
public class sqrt {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int left=0,right=Math.min(x,46340);
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid<=x){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
}
