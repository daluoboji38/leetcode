package leetCode.prefixSum.Array;

import java.util.Arrays;

// 摧毁小行星
public class asteroidsDsty {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;
        Arrays.sort(asteroids);
        if(mass<asteroids[0]){
            return false;
        }else{
            mass+=asteroids[0];
        }
        for (int i = 1; i < n; i++) {
            if(mass<asteroids[i]){
                return false;
            }else if(mass>100000){
                return true;
            }else{
                mass+=asteroids[i];
            }
        }
        return true;
    }
}
