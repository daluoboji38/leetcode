package leetCode.BitOperation.Iteration;

// 用特殊操作处理字符串 I
class ProcessStr2 {
    char processStr(String s, long k) {
        char[] arr = s.toCharArray();
        long sz = 0;
        for (char c : arr) {
            if (c == '*') {
                sz = Math.max(sz - 1, 0);
            } else if (c == '#') {
                sz *= 2;
            } else if (c != '%') {
                sz++;
            }
        }

        if (k >= sz) return '.';

        for (int i = arr.length - 1;; i--) {
            char c = arr[i];
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
                if (k == sz) return c;
            }
        }
    }
}
