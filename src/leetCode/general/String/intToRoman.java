package leetCode.general.String;


public class intToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] arr = Integer.toString(num).toCharArray();
        for (int i = arr.length - 1; i >= 0; i--){
            if(arr[i] -'0'<=3){
                switch(arr.length - i){
                    case 4:
                        sb.append("M".repeat(arr[i] - '0'));
                        break;
                    case 3:
                        sb.append("C".repeat(arr[i] - '0'));
                        break;
                    case 2:
                        sb.append("X".repeat(arr[i] - '0'));
                        break;
                    case 1:
                        sb.append("I".repeat(arr[i] - '0'));
                        break;
                }
            }else if(arr[i] -'0' == 4){
                switch (arr.length - i){
                    case 3:
                        sb.append("DC");
                        break;
                    case 2:
                        sb.append("LX");
                        break;
                    case 1:
                        sb.append("VI");
                        break;
                }
            }else if(arr[i] -'0' == 9) {
                switch (arr.length - i) {
                    case 3:
                        sb.append("MC");
                        break;
                    case 2:
                        sb.append("CX");
                        break;
                    case 1:
                        sb.append("XI");
                        break;
                }
            }else{ // 678
                switch (arr.length - i){
                    case 3:
                        sb.append("C".repeat(arr[i] - '5'));
                        sb.append("D");
                        break;
                    case 2:
                        sb.append("X".repeat(arr[i] - '5'));
                        sb.append("L");
                        break;
                    case 1:
                        sb.append("I".repeat(arr[i] - '5'));
                        sb.append("V");
                        break;
                }
            }
        }
        return sb.reverse().toString();
    }
}
