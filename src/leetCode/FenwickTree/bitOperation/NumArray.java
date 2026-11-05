package leetCode.FenwickTree.bitOperation;

// 区域和检索 - 数组可修改
public class NumArray {
    private int[] nums;
    private int[] tree;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = new int[n];
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int delta=val-nums[index];
        nums[index]=val;
        for(int i=index+1; i<tree.length; i+=i&-i){tree[i]+=delta;} // carries the least significant set bit of `i` to a higher position, which gives the next index on the BIT update path.
    }

    private int prefixSum(int i){
        int s=0;
        for(;i>0;i&=i-1){s+=tree[i];}// i-=i&-i
        return s;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right+1)-prefixSum(left);
    }
}
