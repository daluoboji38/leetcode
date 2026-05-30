package leetCode.general.String;

// 统计特殊字母的数量 I
public class specialLetter {
    public int numberOfSpecialChars(String word) {
        int[] mask=new int[2];
        for(char c:word.toCharArray()){
            mask[c>>5 & 1] |= 1<<(c & 31);
        }
        return Integer.bitCount(mask[0] & mask[1]);
    }
}

/*
* For uppercase English letters:
The 6th bit from the right is always 0.
For lowercase English letters:
The 6th bit from the right is always 1.
For any English letter:
The lower 5 bits of a lowercase letter are identical to the lower 5 bits of its uppercase equivalent.
* */
