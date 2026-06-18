package leetCode.general.caculate;

// 时钟指针的夹角
public class AngleClock {
    public double angleClock(int hour, int minutes) {

        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double minutesAngle = minutes * 6;
        double angle = Math.abs(hourAngle - minutesAngle);
        return angle <= 180 ? angle : 360 - angle;
    }
}
