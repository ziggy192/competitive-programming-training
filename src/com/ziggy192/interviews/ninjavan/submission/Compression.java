package com.ziggy192.interviews.ninjavan.submission;

public class Compression {
	public static void main(String[] args) {
		System.out.println(compressedString("abaasass"));
	}

	public static String compressedString(String message) {
		message += "$";
		Character cur = null;
		int count = 0;
		StringBuilder res = new StringBuilder();
		for (char c : message.toCharArray()) {
			if (cur == null || c != cur) {
				if (cur != null) {
					res.append(cur);
					if (count > 1) {
						res.append(count);
					}
				}
				count = 1;
				cur = c;
			}else {
				count++;
			}
		}
		return res.toString();
	}
}
