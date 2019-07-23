package com.ziggy192.practices;

import java.util.Arrays;

class SegmentTreeImpl {
	static class SegmentTree {
		private int[] arr;
		private int[] pArr;

		private int left(int p) {
			return p << 1;
		}

		private int right(int p) {
			return (p << 1) + 1;
		}

		private void build(int p, int L, int R) {
			if (L == R) {
				pArr[p] = L;
				return;
			}
			build(left(p), L, (L + R) / 2);
			build(right(p), (L + R) / 2 + 1, R);
			int p1 = pArr[left(p)];
			int p2 = pArr[right(p)];
			pArr[p] = arr[p1] <= arr[p2] ? p1 : p2;

		}

		public SegmentTree(int[] arr) {
			this.arr = arr;
			pArr = new int[arr.length * 4];
			build(1, 0, arr.length - 1);

		}

		public int rmq(int p, int L, int R, int i, int j) {
			// not intersect with current segment
			if (R < i || L > j) {
				return -1;
			}

			//inside i-j
			if (i <= L && R <= j) {
				return pArr[p];
			}


			int p1 = rmq(left(p), L, (L + R) / 2, i, j);
			int p2 = rmq(right(p), (L + R) / 2 + 1, R, i, j);
			if (p1 == -1) {
				return p2;
			}
			if (p2 == -1) {
				return p1;
			}
			return arr[p1] <= arr[p2] ? p1 : p2;

		}


		public void update(int index, int value, int p, int L, int R) {
			if (L == R) {
				arr[index] = value;
				return;
			}
			if (index <= (L + R) / 2) {
				update(index, value, left(p), L, (L + R) / 2);
			}else{
				update(index, value, right(p), (L + R) / 2 + 1, R);
			}
			int p1 = pArr[left(p)];
			int p2 = pArr[right(p)];
			pArr[p] = arr[p1] <= arr[p2] ? p1 : p2;

		}
		public void update(int index, int value) {
			update(index, value, 1, 0, arr.length - 1);
		}




		public int rmq(int i, int j) {
			return rmq(1, 0, arr.length - 1, i, j);
		}

		public int[] getArr() {
			return arr;
		}

		public int[] getpArr() {
			return pArr;
		}

		public void updateRange(int i, int j, int[] values, int p, int L, int R) {
			if (L == R) {
				arr[L] = values[L - i];
				return;
			}
			if (i <= (L + R) / 2) {
				updateRange(i, j, values, left(p), L, (L + R )/ 2);
			}
			if (j >= (L + R) / 2 + 1) {
				updateRange(i, j, values, right(p), (L + R) / 2 + 1, R);

			}
			int p1 = pArr[left(p)];
			int p2 = pArr[right(p)];
			pArr[p] = arr[p1] <= arr[p2] ? p1 : p2;
		}

		public void updateRange(int i, int j, int[] values) {
			updateRange(i, j, values, 1, 0, arr.length - 1);
		}


	}

	public static void main(String[] args) {
		int[] a = {18, 17, 13, 19, 15, 11, 20};
		SegmentTree segmentTree = new SegmentTree(a);
		System.out.println(Arrays.toString(segmentTree.getpArr()));
//		System.out.println(segmentTree.rmq(1, 7));
//		System.out.println(segmentTree.rmq(3, 8));

		segmentTree.updateRange(5, 5, new int[]{99});
		System.out.println(Arrays.toString(segmentTree.getpArr()));


	}
}
