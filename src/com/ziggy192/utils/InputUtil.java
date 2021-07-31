package com.ziggy192.utils;

public class InputUtil {

	public static TreeNode buildTree(Integer[] array) {
		return buildTree(array, 0);
	}

	private static TreeNode buildTree(Integer[] array, int i) {
		if (i >= array.length || array[i] == null) return null;
		final TreeNode node = new TreeNode(array[i]);
		node.left = buildTree(array, i * 2 + 1);
		node.right = buildTree(array, i * 2 + 2);
		return node;
	}

	/**
	 * build linked list from array
	 * @return head
	 */
	public static ListNode buildList(int[] array) {
		ListNode head = null;
		ListNode tail = null;
		for (int val : array) {
			ListNode listNode = new ListNode(val);
			if (head == null) {
				head = listNode;
				tail = head;
			} else {
				tail.next = listNode;
				tail = tail.next;
			}
		}
		return head;

	}
}
