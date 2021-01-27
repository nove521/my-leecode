package com.cx.leecode.In202101;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.left = node;
        node = new TreeNode(3);
        root.right = node;
        node = new TreeNode(3);
        root.left.left = node;

        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }

    private void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("*").append(",");
            return;
        }
        sb.append(root.val).append(",");
        encode(root.left, sb);
        encode(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null){
            return null;
        }
        String[] list = data.split(",");
        TreeNode root = new TreeNode();
        index = 0;
        encode(root, list);
        return root;
    }

    private static int index = 0;

    private void encode(TreeNode root, String[] list) {
        if (list.length <= index) {
            return;
        }
        root.val = Integer.parseInt(list[index++]);
        if (list.length > index && !"*".equals(list[index])) {
            root.left = new TreeNode();
            encode(root.left, list);
        }else {
            index++;
        }
        if (list.length > index && !"*".equals(list[index])) {
            root.right = new TreeNode();
            encode(root.right, list);
        }else {
            index++;
        }
    }
}