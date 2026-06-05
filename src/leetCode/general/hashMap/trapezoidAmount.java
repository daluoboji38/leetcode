package leetCode.general.hashMap;
// 统计梯形的数目 I


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class trapezoidAmount {
    public int countTrapezoids(int[][] points) {
        long MOD = 1000000007;
        HashMap<Integer, Integer> HZpoints = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int y = points[i][1];
            HZpoints.put(y, HZpoints.getOrDefault(y, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(HZpoints.keySet());
        for (int y : keys) {
            HZpoints.compute(y, (k, a) -> a * (a - 1) / 2);
        }
        long res = 0;
        for (int i = 0; i < keys.size(); i++) {
            int y = keys.get(i);
            int a = HZpoints.get(y);
            for (int j = i + 1; j < keys.size(); j++) {
                int y2 = keys.get(j);
                int a2 = HZpoints.get(y2);
                res = (res + ((long) a * a2) % MOD) % MOD;
            }
        }
        return (int) res;
    }
}
