package leetCode.tree.BinaryTree.cnt;

import leetCode.tree.BinaryTree.TreeNode;

// 统计值等于子树平均值的节点数
public class subTreeAvgV2 {
    private int ans=0;
    int cnt=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node){
        if(node==null) return 0;
        int tmp=cnt;
        int sum=node.val+dfs(node.left)+dfs(node.right);
        cnt++;
        int size=cnt-tmp;
        if(sum/size==node.val) ans++;
        return sum;
    }
}
