package leetCode.general.Array.find;

// 数据流的中位数
public class findMedianDynamicV2 {
    int OFFSET=100000;
    int[] count =new int[OFFSET*2+1];
    int mid=-1;
    double place=0;

    public void addNum(int num) {
        int target=num+OFFSET;
        count[target]++;
        if(mid==-1){
            mid=target;
            place=0.5;
            return;
        }
        if(target>mid){
            if(place<count[mid]){
                place+=0.5;
            }else{
                do{
                    mid++;
                }while(count[mid]==0);
                place=0.5;
            }
        }else if(target<mid){
            if(place>0.5){
                place-=0.5;
            }else{
                do{
                    mid--;
                }while(count[mid]==0);
                place=count[mid];
            }
        }else{
            place+=0.5;
        }

    }

    public double findMedian() {
        if(place<count[mid]){return (double)mid-OFFSET;}
        int left=mid;
        do{
            left++;
        }while(count[left]==0);
        return (mid+left)/2.0-OFFSET;
    }
}
