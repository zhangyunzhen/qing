package com.zyz.algorithm.tree;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/01/13
 */
public class BinarySearchTree {

    int k, res;


    /**
     * 查找二叉搜索树中的第k大节点
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        recur(root);
        return res;
    }

    // 中序变形（右->中->左）
    public void recur(TreeNode root) {
        if (root == null) return;
        recur(root.right);
        if (k == 1) {
            res = root.val;
        }
        k--;
        recur(root.left);
    }


    /*************************************************************************************************************/

    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val == p.val || root.val == q.val) {
                return root;
            }

            if (root.val > p.val && root.val < q.val) {
                return root;
            }
            if (root.val < p.val && root.val > q.val) {
                return root;
            }

            // 公共祖先在右子树上
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }

            // 公共祖先在左子树上
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
        }

        return root;
    }

/********************************************************************************************************************************/

    /**
     *
     *      二叉搜索树的公共祖先
     *  条件：
     *      node = p || node ==q  return node;
     *      node<p and node <q  recur(node.right);
     *      node >p and node>q recur(node.left);
     *      node<p and node>q return node;
     *
     *
     * @param node
     * @param p
     * @param q
     */
    public TreeNode commonParent(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) return null;

        if (node == p || node == q) return node;
        if (node.val < p.val && node.val < q.val) {
            return commonParent(node.right, p, q);
        }
        if (node.val > p.val && node.val > q.val) {
            return commonParent(node.left, p, q);
        }

        return node;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;


        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**************************二叉搜索树转换成链表*****************************/


    private TreeNode pre;

    private TreeNode head;

    public TreeNode treeToDoublyList(TreeNode root) {

        if (root == null) return null;

        recur2(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void recur2(TreeNode node) {

        recur2(node.left);

        node.left = pre;
        if (pre != null) {
            pre.right = node;
        } else {
            head = node;
        }
        pre = node;

        recur2(node.right);
    }


    /***************************************************/

    /**
     * 二叉搜索树的后序遍历序列
     * <p>
     * 递归求解：二叉搜索树的一个节点的左子树上的任意节点都比它小， 右子树上的任意节点都比它大
     * 数组最后一个节点一定是根节点
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int start, int end) {
        int m = start, j;
        if (start >= end) {
            return true;
        }

        int root = postorder[end];
        while (postorder[m] < root) m++;
        j = m;
        while (postorder[j] > root) j++;

        // 判断整个数组是否符合后序遍历和 递归判断左右子树是否符合后序遍历
        return j == end && recur(postorder, start, m - 1) && recur(postorder, m, j - 1);
    }

}
