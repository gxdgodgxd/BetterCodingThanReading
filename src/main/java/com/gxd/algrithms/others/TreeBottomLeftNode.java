package com.gxd.algrithms.others;

import com.gxd.common.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guoxd on 2019/8/27.
 */
public class TreeBottomLeftNode {

    /**
     * 获取一棵二叉树的最下层最左节点
     */

    public static int getTreeBottomLeftNode(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
        }

        return cur.value;
    }

    public static void main(String[] args) {
//        BinaryTreeNode node6 = BinaryTreeNode.builder().value(6).build();
        BinaryTreeNode node4 = BinaryTreeNode.builder().value(4).build();
//        BinaryTreeNode node5 = BinaryTreeNode.builder().value(5).left(node6).build();
        BinaryTreeNode node5 = BinaryTreeNode.builder().value(5).build();
        BinaryTreeNode node2 = BinaryTreeNode.builder().value(2).right(node4).build();
        BinaryTreeNode node3 = BinaryTreeNode.builder().value(3).left(node5).build();
        BinaryTreeNode node1 = BinaryTreeNode.builder().value(1).left(node2).right(node3).build();

        System.out.println(getTreeBottomLeftNode(node1));

    }


}
