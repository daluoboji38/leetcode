package leetCode.general.String;

// 距离原点最远的点
public class maxDistance {
    public int furthestDistanceFromOrigin(String moves) {
        int diff=0,k=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                diff--;
            }else if(moves.charAt(i)=='R'){
                diff++;
            }else {k++;}
        }
        return Math.abs(diff)+k;
    }
}
