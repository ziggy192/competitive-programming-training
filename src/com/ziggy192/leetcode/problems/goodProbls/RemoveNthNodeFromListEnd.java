package com.ziggy192.leetcode.problems.goodProbls;

import com.ziggy192.utils.InputUtil;
import com.ziggy192.utils.ListNode;
import com.ziggy192.utils.OutputUtil;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromListEnd {
	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 3, 4, 5};
		int n = 5;
		final ListNode head = InputUtil.buildList(a);
		System.out.println(OutputUtil.toString(new Solution().removeNthFromEnd(head, n)));
	}
	static  class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			Pair<ListNode,Integer> p = find(head,n);
			head = p.getKey();
			return head;
		}

		//find and return valid node only,then remap the list
		private Pair<ListNode,Integer> find(ListNode node, int n){
			//find the nth node
			if (node == null) return  new Pair<>(null,0);
			Pair<ListNode,Integer> p = find(node.next, n);
			ListNode nextNode = p.getKey();
			int i = p.getValue()+1;
			if (i != n) {
				node.next = nextNode;
				return new Pair<>(node,i);
			}
			Deque<Integer> a = new ArrayDeque<>(3);
			//i == n
			return new Pair<>(node.next,i);

		}

	}
}
