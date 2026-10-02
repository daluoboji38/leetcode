package leetCode.general.Array.Boolean;

// 矩形重叠
public class rectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int d1,d2;
        if(rec1[0]<rec2[0]){
            d1=rec1[2]-rec2[0];
        }else{
            d1=rec2[2]-rec1[0];
        }
        if(rec1[1]<rec2[1]){
            d2=rec1[3]-rec2[1];
        }else{
            d2=rec2[3]-rec1[1];
        }
        return d1>0 && d2>0;
    }
}
