package com.ziggy192.interviews.ninjavan.test;

public class Example3 {
	public static void main(String[] args) {
		fizzBuzz(15);
	}

	public static void fizzBuzz(int n) {
		// Write your code here
		for (int i = 1; i <=n ; i ++){
			System.out.println(sol(i));
		}
	}

	static String sol(int i){
		if (i % 3 == 0 && i % 5 == 0){
			return "FizzBuzz";
		}else if (i % 3 == 0){
			return "Fizz";
		}else if (i % 5 == 0 ){
			return "Buzz";
		}else {
			return String.valueOf(i);
		}
	}
}
