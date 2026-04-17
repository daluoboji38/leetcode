package leetCode.twoPointer;

import java.util.Arrays;

import static java.lang.Math.*;

// 最接近的三数之和
public class sumThree2 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int diff,sum,res = 0,minDiff=Integer.MAX_VALUE;
        for(int first=0;first<n-2;first++){
            if(first>0 && nums[first]==nums[first-1]) continue;
            int third=n-1;
            diff = target-nums[first];
            for(int second=first+1;second<n-1;second++){
                if(second>first+1 && nums[second]==nums[second-1]) continue;
                while(second<third && nums[second]+nums[third]>diff){
                    third--;
                }
                sum = nums[first]+nums[second]+nums[third];
                if(third==n-1 ){
                    if(minDiff>abs(sum-target)) {
                        minDiff = abs(sum - target);
                        res = sum;
                    }
                    continue;
                }
                int sump1 = nums[first]+nums[second]+nums[third+1];
                if(second==third) {
                    if(minDiff>abs(sump1-target)) {
                        res = sump1;
                        minDiff = abs(sump1 - target);
                    }
                }
                else if (minDiff>min(abs(sum-target),abs(sump1-target))){
                        if (abs(sum-target)>=abs(sump1-target)){
                            res =sump1;
                            minDiff = abs(sump1-target);
                        }
                        else{
                            res = sum;
                            minDiff = abs(sum-target);
                        }
                    }
                };
        }
        return res;
}}
