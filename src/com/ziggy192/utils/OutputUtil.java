package com.ziggy192.utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputUtil {
	public static String toString(ListNode head){
		ListNode node = head;
		List<String> a = new ArrayList<>();

		while (node != null){
			a.add(String.valueOf(node.val));
			node = node.next;
		}
		return "[" + a.stream().collect(Collectors.joining(",")) + "]";
	}

	public static void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.println(node.val);
		inorder(node.right);
	}

	public static void preorder(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.val);
		inorder(node.left);
		inorder(node.right);
	}

}
