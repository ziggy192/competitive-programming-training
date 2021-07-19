package com.ziggy192.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'makeAnagram' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. STRING a
	 *  2. STRING b
	 */

	public static int makeAnagram(String a, String b) {
		Map<Character, Integer> ma = makeMap(a);
		Map<Character, Integer> mb = makeMap(b);
		int count = 0;
		for (char c = 'a'; c <= 'z'; c++) {
			int min = Math.min(ma.getOrDefault(c, 0), mb.getOrDefault(c, 0));
			count += ma.getOrDefault(c, 0) - min;
			count += mb.getOrDefault(c, 0) - min;
		}


		return count;
	}

	private static Map<Character, Integer> makeMap(String a) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			int count = m.getOrDefault(a.charAt(i), 0);
			m.put(a.charAt(i), count + 1);
		}
		return m;
	}

}

public class MakingAnagram {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = bufferedReader.readLine();

		String b = bufferedReader.readLine();

		int res = Result.makeAnagram(a, b);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
