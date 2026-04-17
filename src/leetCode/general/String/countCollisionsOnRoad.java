package leetCode.general.String;
// 统计道路上的碰撞次数


public class countCollisionsOnRoad {
    public static int countCollisions(String directions) {
        int n = directions.length();
        int ans = 0;
        int left=0, right=n-1;
        if(n==1) return 0;
        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'L') {
                left++;
            } else break;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (directions.charAt(i) == 'R') {
                right--;
            } else break;
        }

        if (left > right) {
            return 0;
        }else {
            for (int i = left; i <= right; i++) {
                if (directions.charAt(i) != 'S') {
                    ans++;
                }
            }
        }
        return ans;
    }
}


