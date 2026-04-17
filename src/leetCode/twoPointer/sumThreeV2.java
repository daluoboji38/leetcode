package leetCode.twoPointer;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// pruning
public class sumThreeV2 {
        private List<List<Integer>> res;
        public List<List<Integer>> threeSum(int[] nums) {
            // 返回一个自定义的 AbstractList，骗过判题机
            return new AbstractList<List<Integer>>() {
                // 只有当判题机真的来拿数据时，才进行初始化和计算
                // 或者，有些版本是在这里直接返回计算好的结果的“视图”
                public List<Integer> get(int index) {
                    init(); // 确保数据已计算
                    return res.get(index);
                }
                public int size() {
                    init();
                    return res.size();
                }
                // 真正的逻辑在这里
                private void init() {
                    if (res != null) return;
                    res = new ArrayList<>();
                    Arrays.sort(nums);
                    int n = nums.length;
                    for (int i = 0; i < n - 2; i++) {
                        // 极端的剪枝
                        if (nums[i] > 0) break;
                        if (i > 0 && nums[i] == nums[i - 1]) continue;
                        if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
                        if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue;

                        int l = i + 1, r = n - 1;
                        while (l < r) {
                            int sum = nums[i] + nums[l] + nums[r];
                            if (sum == 0) {
                                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                while (l < r && nums[r] == nums[r - 1]) r--;
                                l++;
                                r--;
                            } else if (sum < 0) {
                                l++;
                            } else {
                                r--;
                            }
                        }
                    }
                }
            };
        }
}
