package leetCode.general.Array;

public class sepaDigitsV2 {
    public int[] separateDigits(int[] nums) {
        int m=nums.length,idx=0;
        int[] tmp=new int[m * 6];
        for(int num:nums) {
            int start=idx;
            int temp=num;
            while(temp!=0){
                tmp[idx++]=temp%10;
                temp/=10;
            }
            reverse(tmp,start,idx-1);

        }
        int[] ans=new int[idx-1];
        System.arraycopy( tmp, 0, ans, 0, idx-1 );
        return ans;
    }


    public void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start++]=arr[end];
            arr[end--]=temp;
        }
    }
}
