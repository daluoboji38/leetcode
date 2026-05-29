package leetCode.general.String.Array;

import java.util.HashMap;

class Node {
    Node[] son = new Node[26];
    int minLen = Integer.MAX_VALUE;
    int bestIndex;
}

// 最长公共后缀查询
public class longestPublicSuffix {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();
        for (int i = 0; i < wordsContainer.length; i++) {
            char[] s = wordsContainer[i].toCharArray();
            if(s.length<root.minLen){
                root.minLen=s.length;
                root.bestIndex=i;
            }

            Node cur = root;
            for (int j = s.length - 1; j >= 0; j--) {
                int b = s[j]-'a';
                if (cur.son[b] == null) {
                    cur.son[b] = new Node();
                }
                cur = cur.son[b];
                if(s.length<cur.minLen){
                    cur.minLen=s.length;
                    cur.bestIndex=i;
                }
            }
        }

        int[] ans = new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            String s = wordsQuery[i];
            Node cur=root;
            for(int j=s.length()-1;j>=0 && cur.son[s.charAt(j)-'a']!=null;j--){
                cur=cur.son[s.charAt(j)-'a'];
            }
            ans[i]=cur.bestIndex;
        }
        return ans;
    }
}
