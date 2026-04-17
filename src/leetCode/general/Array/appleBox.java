package leetCode.general.Array;
// 重新分装苹果

import java.util.Arrays;

public class appleBox {
    public int minimumBoxes(int[] apple,int[] capacity) {
        int sum = 0,current=0;
        for(int i=0;i<apple.length;i++){
            sum+=apple[i];
        }
        int n= capacity.length-1;
        while(current<sum){
            for(int i=0;i<n;i++){
               if(capacity[i]>capacity[i+1]){
                   int tmp=capacity[i];
                   capacity[i]=capacity[i+1];
                   capacity[i+1]=tmp;
               }
            }
            current+=capacity[n];
            n--;
        }
        return capacity.length-1-n;
    }
}
