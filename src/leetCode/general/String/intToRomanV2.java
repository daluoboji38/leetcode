package leetCode.general.String;
// 整数转罗马数字
public class intToRomanV2 {
    // M    D   C   L  X  V I
    // 1000 500 100 50 10 5 1
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
                if(num == 0){
                    break;
                }
            }
        }
        return sb.toString();
    }
}
