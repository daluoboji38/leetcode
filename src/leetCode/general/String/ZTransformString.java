package leetCode.general.String;

import java.util.ArrayList;
// Z字形变换
public class ZTransformString {
    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        for (int i = 0; i < s.length() ; i++) {
            int row = i % (2 * numRows - 2);
            if (row < numRows) {
                rows.get(row).append(s.charAt(i));
            } else {
                rows.get(2 * numRows - 2 - row).append(s.charAt(i));
            }

        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row2 : rows) {
            result.append(row2.toString());
        }
        return result.toString();
    }
}
