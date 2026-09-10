/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 public class Pair{
    public int noOfNodes;
    public int totalSum;
    public int ansCount;
 }
class Solution {
    public Pair solve(TreeNode root){
        if(root == null){
            return new Pair();
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int sum = left.totalSum + right.totalSum + root.val;

        Pair p = new Pair();
        p.totalSum = sum;
        p.noOfNodes = left.noOfNodes + right.noOfNodes + 1;

        if(p.totalSum/p.noOfNodes == root.val){
            p.ansCount = left.ansCount + right.ansCount + 1;
        }else{
            p.ansCount =  left.ansCount + right.ansCount;
        }

        return p;

    }
    public int averageOfSubtree(TreeNode root) {
       Pair ans = solve(root);
       return ans.ansCount;
    }
}