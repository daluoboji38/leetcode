package leetCode.general.location;

// 圆和矩形是否有重叠
public class CircleRectangleOverlap {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xm=x1+x2>>1;
        int ym=y1+y2>>1;
        xm=xm>=xCenter?Math.abs(x1-xCenter):Math.abs(x2-xCenter);
        ym=ym>=yCenter?Math.abs(y1-yCenter):Math.abs(y2-yCenter);
        if(yCenter>y1 && yCenter<y2 && xCenter>x1 && xCenter<x2) return true;
        if(radius>=xm && yCenter>y1 && yCenter<y2)return true;
        if(radius>=ym && xCenter>x1 && xCenter<x2)return true;
        return radius*radius >=xm*xm+ym*ym;
    }
}
