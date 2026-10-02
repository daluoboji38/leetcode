package leetCode.general.TDArray.gridMove;

import java.util.List;


// 图像重叠
// Cross-correlation = spatially flip B, then convolve with A.
public class imageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans=0;
        for(int dx=1-n;dx<n;dx++){
            for(int dy=1-n;dy<n;dy++){
                int cnt=0;
                for(int i=Math.max(-dx,0);i<Math.min(n-dx,n);i++){
                    for(int j=Math.max(-dy,0);j<Math.min(n-dy,n);j++){
                        cnt+=img1[i][j]*img2[i+dx][j+dy];
                    }
                }
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
}
