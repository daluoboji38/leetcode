package leetCode.binarySearch.Array;

// 最小公共值
public class publicMin {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0,l1=nums1.length,l2=nums2.length;
        while (i < l1 && j < l2) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i=search(nums1, i, l1, nums2[j]);
            } else {
                j=search(nums2, j, l2, nums1[i]);
            }
        }
        return -1;
    }

    public int search(int[] nums,int left,int right, int target) {
        while(left+1<right){
            int mid = (left + right) >>>1 ;// equal to mid = (l + r) / 2 but safer and faster
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
