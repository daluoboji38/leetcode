package leetCode.general.hashSet;

public class LongestConsecutiveV2 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n<2)return n;

        int min=nums[0],max=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
            }else if(nums[i]>max){
                max=nums[i];
            }
        }
        long range=(long)max-min+1;

        // Dense data: Marked with boolean arrays
        if(range<=n*10L){
            byte[] present=new byte[(int)range];
            for(int num:nums){
                present[num-min]=1;
            }
            int maxLen=0,currLen=0;
            for(byte b:present){
                if(b==1){
                    currLen++;
                }else{
                    maxLen=Math.max(maxLen,currLen);
                    currLen=0;
                }
            }
            return Math.max(maxLen,currLen);
        }

        // Sparse data: Open-addressing hash tables
        int capacity=2;
        while(capacity<n*2){
            capacity*=2;
        }
        int mask=capacity-1;
        int[] keys=new int[capacity];
        byte[] states=new byte[capacity];

        int unique=0;
        for(int num:nums){
            int idx=num&mask; // equal to num % capacity
            while(states[idx]==1){
                if(keys[idx]==num)break;
                idx=(idx+1)&mask;
            }
            if(states[idx]==0){
                keys[idx]=num;
                states[idx]=1;
                nums[unique++]=num;
            }
        }

        int maxLen=0;
        for(int i=0;i<unique;i++){
            int num=nums[i];
            if(!contains(keys,states,mask,num-1)){
                int len=i;
                while(contains(keys,states,mask,num+len)){
                    len++;
                }
                maxLen=Math.max(maxLen,len);
                if(maxLen*2>=unique){return maxLen;}
            }
        }
        return maxLen;
    }

    private boolean contains(int[] keys,byte[] states,int mask, int num){
        int idx=num&mask;
        while(states[idx]==1){
            if(keys[idx]==num)return true;
            idx=(idx+1)&mask;
        }
        return false;
    }
}
