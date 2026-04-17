package leetCode.general.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 统计梯形的数目 II
public class trapezoidAmount2 {
    public int countTrapezoids(int[][] points) {
        Map<Double, List<Double>> groups = new HashMap<>(); // slope->[intercept]
        Map<Integer, List<Double>> groups2 = new HashMap<>(); // midpoint->[slope]
        // Instead of creating an internal hash table, we first store the data in a lighter list
        // and create hashmap lately for group size > 1

        int n = points.length;
        for (int i = 0; i < n; i++) {
            int x=points[i][0], y=points[i][1];
            for (int j=0; j<i; j++){
                int x2=points[j][0], y2=points[j][1];
                int dx=x-x2, dy=y-y2;
                // when float caculation is  not accurate? the number value > 2^26 approximately equals to 6.7*10^7
                double k=dx!=0? (double)dy/dx : Double.MAX_VALUE;
                if(k==-0.0) k=0.0;
                double b=dx!=0?1.0*(y*dx-x*dy)/dx:x;
                groups.computeIfAbsent(k, _ -> new ArrayList<>()).add(b);
                int mid =(x+x2+2000)*10000+(y+y2+2000);// compresses two dimensions coordinates into int
                groups2.computeIfAbsent(mid, _ -> new ArrayList<>()).add(k);
            }
        }

        int ans=0;
        Map<Double, Integer> cnt = new HashMap<>();
        for(List<Double> g: groups.values()){
            if(g.size()==1)continue;
            cnt.clear();
            for(double b: g){
                if(b==-0.0)b=0.0;
                cnt.merge(b, 1, Integer::sum);
            }
            int s=0;
            for(int c: cnt.values()){
                ans+=s*c; // enumerate the right, maintain the left
                s+=c;
            }
        }

        for(List<Double> g: groups2.values()){
            if(g.size()==1)continue;
            cnt.clear();
            for(double k: g){
                cnt.merge(k, 1, Integer::sum);
            }
            int s=0;
            for(int c: cnt.values()){
                ans-=s*c; // Parallelograms will be counted twice; subtract the extra count
                s+=c;
            }
        }
        return ans;
    }
}
