package com.ziggy192.hackerrank;

import java.io.*;

public class InputTemplate {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); // changed this from OUTPUT_PATH

		String a = bufferedReader.readLine();

		String b = bufferedReader.readLine();

		int res = 0; // result of the solution

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}

