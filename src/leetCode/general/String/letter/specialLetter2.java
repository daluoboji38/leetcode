package leetCode.general.String.letter;

// 统计特殊字母的数量 II
public class specialLetter2 {
    public int numberOfSpecialChars(String word) {
        int[] mask=new int[27];
        int ans=0;
        for(char c:word.toCharArray()){
            int loc=c & 31;
            if(mask[loc]==-1){continue;}
            int idx=c>>5 & 1;
            // idx=1:lowercase
            if(idx==1){
                if( mask[loc]==0) {
                    mask[loc] = 1;
                }else if(mask[loc]==2){
                    mask[loc] = -1;
                }
            }else{// idx=0:uppercase
                if(mask[loc]==1) {
                    mask[loc] = 2;
                }else if(mask[loc]==0){
                    mask[loc]=-1;
                }
            }
        }
        for(int i:mask){
            if(i==2){ans++;}
        }
        return ans;
    }
}
/*00011100
* 00010100*/