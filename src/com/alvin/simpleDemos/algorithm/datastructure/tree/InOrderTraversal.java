package com.alvin.simpleDemos.algorithm.datastructure.tree;

import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeBin<String> root = new TreeBin<>("root");
        TreeBin<String> child1_1 = new TreeBin<>("child1_1");
        TreeBin<String> child1_2 = new TreeBin<>("child1_2");
        TreeBin<String> child2_1 = new TreeBin<>("child2_1");
        TreeBin<String> child2_2 = new TreeBin<>("child2_2");
        TreeBin<String> child2_3 = new TreeBin<>("child2_3");
        root.left = child1_1;
        root.right = child1_2;
        child1_1.left = child2_1;
        child1_1.right = child2_2;
        child1_2.right = child2_3;

        System.out.println("中序遍历递归实现：");
        recursiveImplement(root);
        System.out.println("\n中序遍历fei递归实现：");
        iterativeImplement(root);
    }

    private static void recursiveImplement(TreeBin<String> root) {
        if (root != null) {
            recursiveImplement(root.left);
            System.out.print(root.value + ", ");
            recursiveImplement(root.right);
        }
    }

    private static void iterativeImplement(TreeBin<String> root) {
        Stack<TreeBin<String>> binStack = new Stack<>();
        while (root != null || !binStack.isEmpty()) {
            while (root != null) {
                binStack.push(root);
                root = root.left;
            }

            if (!binStack.isEmpty()) {
                root = binStack.pop();
                System.out.print(root.value + ", ");
                root = root.right;
            }
        }
    }
}
