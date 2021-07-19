package com.ziggy192.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RectanglePoints {
	public int minAreaRect(int[][] points) {
		Set<Point> set = new HashSet<>();
		for ( int[] point : points){
			set.add(new Point(point[0],point[1]));
		}
		Integer res = null;
		for (int i = 0; i < points.length-1; i++){
			for (int j = i+1; j < points.length; j++) {
				int x1 = points[i][0];
				int y1 = points[i][1];
				int x2 = points[j][0];
				int y2 = points[j][1];
				System.out.printf("%d,%d|%d,%d\n",x1,y1,x2,y2);
				if (set.contains(new Point(x1,y1)) &&
						set.contains(new Point(x1,y2)) &&
						set.contains(new Point(x2,y1)) &&
						set.contains(new Point(x2,y2))){
					int area = Math.abs(x1-x2)*Math.abs(y1-y2);
					if (area == 0) continue;
					if (res == null) {
						res  = area;
					} else {
						res = Math.min(res,area);
					}
				}
			}
		}

		return res == null ? 0 : res;
	}
	static class Point{
		int x;
		int y;

		Point(int x, int y){
			this.x=x;
			this.y=y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		public boolean equals(Object o){
			Point p = (Point)o;
			boolean res =  this.x ==p.x && this.y == p.y;
			System.out.printf("%d,%d|%d,%d|%s\n",this.x,this.y,p.x,p.y,res);
			return res;
		}
	}

	public static void main(String[] args) {
		System.out.println(new RectanglePoints().minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3}}));
	}
}
