package leetCode.general.Array;
// 1比特与2比特字符
public class bitOneTwo {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length==1)return true;
        return patternMatch(bits, 0);
    }

    private boolean patternMatch(int[] bits, int index) {
        if(bits[index]==0) {
            if(index==bits.length-2){
                return true;
            }else{
            return patternMatch(bits, index + 1);
            }
        }else if(index==bits.length-3){
            return true;
        } else if (index<bits.length-3) {
            return patternMatch(bits, index + 2);
        }else{
            return false;
        }
    }
}
