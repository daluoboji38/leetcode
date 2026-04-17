package leetCode.general.String;
// 将1移动到末尾的最大操作次数
public class moveOne {
    public int maxOperations(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        int count=0;
        while (true){
            index=scan(chars,0);
            if(index==-1) break;
            index=move(chars,index);
            count++;
            while(true){
                index=scan(chars,index);
                if(index==-1) break;
                index=move(chars,index);
                count++;
            }
        }
        return count;
    }

    private int scan(char[] chars, int index) {
        int i;
        for (i = index; i < chars.length-1; i++) {
            if (chars[i] == '1' && chars[i + 1] == '0') {
                index = i;
                break;
            }
        }
        if(i>=chars.length-1) index=-1;
        return index;
    }

    private int move(char[] chars, int index) {
        int res=index+1;
        for (int i = index+1; i < chars.length - 1; i++) {
            if(chars[i+1]!='0') break;
            res++;
        }
        chars[index]='0';
        chars[res]='1';
        return res+1;
    }
}
