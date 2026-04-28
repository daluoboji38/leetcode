package leetCode.general.String;

// 外观数列
public class appearanceArr {
    public String countAndSay(int n) {
        String str="1";
        for (int i=2;i<=n;i++){
            StringBuilder sb=new StringBuilder();
            int start=0,pos=0;

            while(pos<str.length()){
                while(pos<str.length()&&str.charAt(pos)==str.charAt(start)){
                    pos++;
                }
                // sb.append(Integer.toString(pos-start)).append(str.charAt(start));
                sb.append((char)(pos-start+'0')).append(str.charAt(start));;
                start=pos;
            }
            str=sb.toString();
        }
        return str;
    }
}
