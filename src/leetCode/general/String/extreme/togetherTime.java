package leetCode.general.String.extreme;

// 统计共同度过的日子数
public class togetherTime {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] month={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int aam=Integer.parseInt(arriveAlice.substring(0,2));
        int aad=Integer.parseInt(arriveAlice.substring(3));
        int bam=Integer.parseInt(arriveBob.substring(0,2));
        int bad=Integer.parseInt(arriveBob.substring(3));
        if(aam==bam){
            aad=Math.max(aad,bad);
        }else if(aam<bam){
            aam=bam;
            aad=bad;
        }

        int alm=Integer.parseInt(leaveAlice.substring(0,2));
        int ald=Integer.parseInt(leaveAlice.substring(3));
        int blm=Integer.parseInt(leaveBob.substring(0,2));
        int bld=Integer.parseInt(leaveBob.substring(3));
        if(alm==blm){
            ald=Math.min(ald,bld);
        }else if(alm>blm){
            alm=blm;
            ald=bld;
        }
        int a=0,b=0;
        for(int i=1;i<aam;i++){
            a+=month[i];
        }
        a+=aad;
        for(int i=1;i<alm;i++){
            b+=month[i];
        }
        b+=ald;
        return Math.max(0,b-a+1);
    }
}
