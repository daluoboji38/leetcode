package leetCode.general.String;
// enumerate every roman numeral and its corresponding value
public class romanToIntV3 {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'I') {
                res += 1;
            } else if (c == 'V') {
                if (i - 1 >= 0) {
                    if (s.charAt(i - 1) != 'I') {
                        res += 5;
                    }else {
                        res += 4;
                        i--;
                    }
                }else {
                    res += 5;
                }
            } else if (c == 'X') {
                if (i - 1 >= 0) {
                    if (s.charAt(i - 1) != 'I') {
                        res += 10;
                    }else {
                        res += 9;
                        i--;
                    }
                }else {
                    res += 10;
                }
            } else if (c == 'L') {
                if (i - 1 >= 0) {
                    if (s.charAt(i - 1) != 'X') {
                        res += 50;
                    }else {
                        res += 40;
                        i --;
                    }
                }else {
                    res += 50;
                }
            } else if (c == 'C') {
                if (i - 1 >= 0) {
                    if (s.charAt(i - 1) != 'X') {
                        res += 100;
                    }else {
                        res += 90;
                        i --;
                    }
                }else {
                    res += 100;
                }
            } else if (c == 'D') {
                if (i - 1 >= 0) {
                    if (s.charAt(i - 1) != 'C') {
                        res += 500;
                    }else {
                        res += 400;
                        i --;
                    }
                }else {
                    res += 500;
                }
            } else if (c == 'M') {
                if (i - 1 >= 0) {
                    if (s.charAt(i - 1) != 'C') {
                        res += 1000;
                    }else {
                        res += 900;
                        i --;
                    }
                }else {
                    res += 1000;
                }
            }
        }
        return res;
    }
}
