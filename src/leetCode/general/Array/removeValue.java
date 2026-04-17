package leetCode.general.Array;
// 移除元素
public class removeValue {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {continue;}
            ans++;
            nums[ans-1]=nums[i];
        }
        return ans;
    }
}
