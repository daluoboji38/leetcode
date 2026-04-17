package leetCode.general.TDArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class numberOfBeams {
    public static void main(String[] args)  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern p = Pattern.compile("\"([01]+)\"");
        String input = null;
        try {
            input = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Matcher m = p.matcher(input);
        List<String> rows = new ArrayList<>();
        while (m.find()) {
            rows.add(m.group(1));
        }
        int[][] grid = new int[rows.size()][rows.get(0).length()];
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.get(0).length(); j++) {
                grid[i][j] = rows.get(i).charAt(j) - '0';
            }

        }
        System.out.println(countBeams(grid));
    }

    public static int countBeams(int[][] grid) {
        int[] rowSum = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowSum[i] += grid[i][j];
            }
        }
        int lastRow = -1;
        int count = 0;
        for (int i = 0; i < rowSum.length; i++){
            if (rowSum[i]>0 && lastRow!=-1) count += rowSum[i] * rowSum[lastRow];
            if (rowSum[i]>0) lastRow = i;
        }
        return count;
    }
}
