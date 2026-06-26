package leetCode.general.Array;

// “气球” 的最大数量
public class MaxSpellOutBalloon {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[5];
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'a':
                    count[0]++;
                    break;
                case 'b':
                    count[1]++;
                    break;
                case 'n':
                    count[2]++;
                    break;
                case 'o':
                    count[3]++;
                    break;
                case 'l':
                    count[4]++;
                    break;
            }
        }
        count[4] /= 2;
        count[3] /= 2;
        int min = count[0];
        for (int i = 1; i < 5; i++) {
            min = Math.min(min, count[i]);
        }
        return min;
    }
}
