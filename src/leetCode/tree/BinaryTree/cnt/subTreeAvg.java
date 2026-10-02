package leetCode.tree.BinaryTree.cnt;

import leetCode.tree.BinaryTree.TreeNode;

// 统计值等于子树平均值的节点数
public class subTreeAvg {
    private int ans=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node){
        if(node==null) return new int[]{0,0};
        int[] left=dfs(node.left);
        int[] right=dfs(node.right);
        int sum=left[0]+right[0]+node.val;
        int size=left[1]+right[1]+1;
        if(sum/size==node.val) ans++;
        return new int[]{sum,size};
    }
}
