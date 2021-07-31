package com.ziggy192.leetcode.explore.topInterviewQuestions;

import com.ziggy192.utils.InputUtil;
import com.ziggy192.utils.TreeNode;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;

public class SymmetricTree {
	public static void main(String[] args) {
//		TreeNode root = InputUtil.buildTree(new Integer[]	{1,2,2,null,3,null,3},0);
//		System.out.println(new Solution().isSymmetric(root));
	}

	static class Solution {
		public boolean isSymmetric(TreeNode root) {
			return isSymmetric(root.left, root.right);
		}

		public boolean isSymmetric(TreeNode left, TreeNode right) {
			if (left == null || right == null) {
				return left == right;
			}
			return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
	}

}
