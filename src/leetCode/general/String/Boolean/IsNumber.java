package leetCode.general.String.Boolean;

// 有效数字
public class IsNumber {
    public boolean isNumber(String s) {
        // return s.matches("[\\+-]?((\\d+(\\.\\d*)?)|\\.\\d+)([eE][\\+-]?\\d+)?");
        char[] arr = s.toCharArray();
        int n = arr.length;

        int i=0;
        if(arr[i]=='+'||arr[i]=='-') i++;

        boolean numeric = false;
        boolean dot = false;
        for(;i<n && arr[i] != 'e' && arr[i] != 'E';i++){
            if(arr[i]=='.'){
                if(dot) return false;
                dot = true;
            }
            else if(arr[i]>='0'&&arr[i]<='9') numeric = true;
            else return false;
        }

        if(!numeric) return false;

        if(i<n && (arr[i]=='e'||arr[i]=='E')){
            i++;
            if(i<n&&(arr[i]=='+'||arr[i]=='-')) i++;
            if(i==n) return false;
            while(i<n&&arr[i]>='0'&&arr[i]<='9') i++;
        }
        return i==n;
    }
}
