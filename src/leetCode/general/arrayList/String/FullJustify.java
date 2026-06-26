package leetCode.general.arrayList.String;

import java.util.ArrayList;
import java.util.List;

// 文本左右对齐
public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int[][] space = new int[n][2];
        int i = 0, row = 0;
        while (i < n) {
            int left = maxWidth, cnt = 0;
            while (i < n && left-cnt >= words[i].length()) {
                left -= words[i].length();
                cnt++;
                i++;
            }
            space[row][0] = cnt;
            space[row][1] = left;
            row++;
        }

        List<String> res = new ArrayList<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < row -1; j++) {
            if (space[j][0] > 1) {
                int len = space[j][1] / (space[j][0] - 1);
                int reminder = space[j][1] % (space[j][0] - 1);
                for (int k = 0; k < space[j][0]; k++) {
                    sb.append(words[idx++]);
                    if (k < space[j][0] - 1) {
                        sb.append(" ".repeat(len));
                        if (k < reminder) sb.append(" ");
                    }
                }
            } else {
                sb.append(words[idx++]);
                sb.append(" ".repeat(space[j][1]));
            }
            res.add(sb.toString());
            sb.setLength(0);
        }
        while(idx<n){
            sb.append(words[idx++]);
            sb.append(" ");
        }
        int remain=space[row-1][1]-space[row-1][0];
        if(remain>0){
            sb.append(" ".repeat(remain));
            res.add(sb.toString());
        }else {
            res.add(sb.substring(0, maxWidth));
        }
        return res;
    }
}
