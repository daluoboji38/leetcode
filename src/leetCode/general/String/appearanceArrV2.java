package leetCode.general.String;


public class appearanceArrV2 {
    public String countAndSay(int n) {
        String res="1";
        for (int i=2;i<=n;i++){res=recur(res);}
        return res;
    }

    public String recur(String s){
        StringBuilder sb=new StringBuilder();
        int len=s.length();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            int  count=0;
            while(i<len && s.charAt(i)==c){
                i++;
                count++;
            }
            i--;
            char countc=(char)('0'+count);
            sb.append(countc);
            sb.append(c);
        }
        return sb.toString();
    }
}
