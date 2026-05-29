package leetCode.tree.String;

// 实现 Trie (前缀树)
class Trie {

    private static class Node{
        Node[] son=new Node[26];
        boolean end=false;
    }

    private final Node root=new Node();

    public void insert(String word) {
        Node cur=root;
        for(char c:word.toCharArray()){
            c-='a';
            if(cur.son[c]==null){
                cur.son[c]=new Node();
            }
            cur=cur.son[c];
        }
        cur.end=true;
    }

    public boolean search(String word) {
        return find(word)==2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix)!=-1;
    }

    private int find(String word){
        Node cur=root;
        for(char c:word.toCharArray()){
            c-='a';
            if(cur.son[c]==null){
                return -1;
            }
            cur=cur.son[c];
        }
        return cur.end?2:1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
