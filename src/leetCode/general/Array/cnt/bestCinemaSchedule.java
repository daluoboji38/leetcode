package leetCode.general.Array.cnt;

import java.util.HashMap;
import java.util.Map;

// 安排电影院座位
public class bestCinemaSchedule {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Integer> seats = new HashMap<>();
        for(int[] r:reservedSeats){
            int seat =r[1];
            if(2<=seat&&seat<=9){
                seats.merge(r[0],1<<(seat-2),(a,b)->a|b);
            }
        }

        int ans=2*(n-seats.size());
        for(int x:seats.values()){
            if((x&0b1111)==0 || (x&0b111100)==0 || (x&0b11110000)==0){
                ans++;
            }
        }
        return ans;
    }
}
