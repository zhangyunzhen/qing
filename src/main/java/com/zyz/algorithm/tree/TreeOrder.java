package com.zyz.algorithm.tree;

import com.zyz.algorithm.linklist.Node;

import java.util.*;

/**
 * 树的遍历
 *
 * @author yunzhen.zhang
 * @date 2021/07/18
 */
public class TreeOrder {


    /**
     * 前序遍历
     *   根-左-右
     */
    public void preOrder(TreeNode node) {
        if (node == null) return;

        System.out.println(node.val);

        preOrder(node.left);

        preOrder(node.right);
    }

    /**
     * 中序遍历
     *  左-根-右
     */
    public void inOrder(TreeNode node) {
        if (node == null) return;

        preOrder(node.left);

        System.out.println(node.val);

        preOrder(node.right);
    }


    /**
     * 后序遍历
     * 根-左-右
     *
     */
    public void postOrder(TreeNode node) {
        if (node == null) return;

        preOrder(node.left);

        preOrder(node.right);

        System.out.println(node.val);
    }


    /**
     * 层序遍历
     *
     * @param node
     */
    public void levelOrder(TreeNode node) {
        if (node == null) return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.println(tempNode);
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }


    /**
     * 非递归前序遍历（栈实现）
     * 1. 若当前节点存在，就存入栈中，并访问左子树；
     * 2. 直到当前节点不存在，就出栈，并通过栈顶节点访问右子树；
     * 3. 不断重复12，直到当前节点不存在且栈空。
     *
     * @param node
     */
    public static void stackPreOrder(TreeNode node) {

        if (node == null) return;

        TreeNode cur = node;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                // 输出这个结点
                System.out.println(cur.val);

                // 左节点加入栈中
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }
    }


    /**
     * 非递归中序遍历（栈实现）
     * 和前序思路一样
     *
     * @param node
     */
    public static void stackInOrder(TreeNode node) {

        if (node == null) return;

        TreeNode cur = node;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);

                // 左节点加入栈中
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();

                // 中序结点输出
                System.out.println(pop.val);

                cur = pop.right;
            }
        }
    }


    /**
     * 非递归后序遍历（栈实现）
     * <p>
     *     和非递归前序 中序思路差不多，但是要判断结点次数，结点访问第二次要输出
     *
     * @param node
     */
    public static void stackPostOrder(TreeNode node) {

        if (node == null) return;

        TreeNode cur = node;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();

        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                map.put(cur, 1);

                // 左节点加入栈中
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (map.get(cur) == 2) {//第二次访问，抛出
                    TreeNode pop = stack.pop();
                    System.out.print(pop.val);
                    cur = null;//需要往上走
                } else {
                    map.put(cur, 2);
                    cur = cur.right;
                }
            }
        }

    }


    /***********************重建二叉树*****************************/

    public Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        this.preorder = preorder;

        TreeNode node = recur(0, 0, inorder.length - 1);
        return node;
    }

    public TreeNode recur(int preRootIdx, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // 获取根节点
        int rootValue = preorder[preRootIdx];
        TreeNode root = new TreeNode(rootValue);

        // 根结点在中序数组中的index
        int rootInIndex = map.get(rootValue);
        // 左子树的长度
        int leftLength = rootInIndex - inStart;

        root.left = recur(preRootIdx + 1, inStart, rootInIndex - 1);

        root.right = recur(preRootIdx + leftLength + 1, rootInIndex + 1, inEnd);
        return root;
    }

    /****************************************************************/

    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            mirrorTree(root.left);
            mirrorTree(root.right);
            TreeNode tmpNode = root.left;
            root.left = root.right;
            root.right = tmpNode;
            return root;
        }


    }


    public static void main(String[] args) {
        // 1 2 4 5 3 6
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node5, node3);
        TreeNode node4 = new TreeNode(4, node6, null);
        TreeNode node1 = new TreeNode(1, node2, node4);

    }

}
