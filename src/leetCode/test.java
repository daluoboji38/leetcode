package leetCode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class test {
    char processStr(String S, long k) {
        char[] s = S.toCharArray();
        long sz = 0;
        for (char c : s) {
            if (c == '*') {
                sz = Math.max(sz - 1, 0);
            } else if (c == '#') {
                sz *= 2;
            } else if (c != '%') {
                sz++;
            }
        }

        if (k >= sz) {
            return '.';
        }

        for (int i = s.length - 1; ; i--) {
            char c = s[i];
            if (c == '*') {
                sz++;
            } else if (c == '#') {
                sz /= 2;
                if (k >= sz) {
                    k -= sz;
                }
            } else if (c == '%') {
                k = sz - 1 - k;
            } else {
                sz--;
                if (k == sz) {
                    return c;
                }
            }
        }
    }
}

