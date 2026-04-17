package leetCode.general.Array;

public class arraySplitPointV2 {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int ans = 0;
        int pre = 0;
        for (int x : nums) {
            if (x > 0) {
                pre += x;
            } else {
                int diff = Math.abs(pre * 2 - total);
                ans += Math.max(2 - diff, 0);
            }
        }
        return ans;
    }
}
