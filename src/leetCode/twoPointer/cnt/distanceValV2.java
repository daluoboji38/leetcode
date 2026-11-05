package leetCode.twoPointer.cnt;

// 两个数组间的距离值
public class distanceValV2 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c=0;
        for(int x:arr1){
            boolean f=true;
            for(int y:arr2){
                if(x>=y-d && x<=y+d){
                    f=false;
                    break;
                }
            }
            if(f){c++;}
        }
        return c;
    }
}
