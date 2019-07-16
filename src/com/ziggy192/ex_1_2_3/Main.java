package com.ziggy192.ex_1_2_3;

import org.omg.CORBA.INTERNAL;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {


		/*1*/
		Scanner scanner = new Scanner(" 1.4732\n15.324547327\n");
		while (scanner.hasNextLine()) {
			double value = scanner.nextDouble();
			scanner.nextLine();
			System.out.printf("%7.3f\n", value);
		}


		/*2*/
		scanner = new Scanner("0\n");
		int n = scanner.nextInt();
		String formatPattern = "#.";
		for (int i = 0; i < n; i++) {
			formatPattern += "#";
		}


		System.out.println(new DecimalFormat(formatPattern).format(Math.PI)+"\n");


		//3

		scanner = new Scanner("2010-08-09");

		LocalDate date = LocalDate.parse(scanner.next());
		System.out.println(date.getDayOfWeek().name());

		//4

		scanner = new Scanner("2 2  2 4 4  5 6 7 8 9 4 3 2 1 1");
		ArrayList<Integer> list = new ArrayList<>();
		while (scanner.hasNextInt()) {
			list.add(scanner.nextInt());
		}



		List<Integer> sortedDistinctLIst = list.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedDistinctLIst);

		//5

		scanner = new Scanner("12,09,1999\n14,07,1996\n14,07,1995");

		List<LocalDate> birthDates = new ArrayList<>();

		while (scanner.hasNextLine()) {
			String string = scanner.nextLine();
			LocalDate birthDate = LocalDate.parse(string, DateTimeFormatter.ofPattern("dd,MM,yyyy"));

			birthDates.add(birthDate);
		}

		birthDates =  birthDates.stream().sorted((o1, o2) ->
				o1.getMonthValue() - o2.getMonthValue() != 0 ? o1.getMonthValue() - o2.getMonthValue()
				: (o1.getDayOfMonth() - o2.getDayOfMonth() != 0 ? o1.getDayOfMonth() - o2.getDayOfMonth() :
				(o2.getYear() - o1.getYear()))).collect(Collectors.toList());

		System.out.println(birthDates);

		//6

		scanner = new Scanner("774");
		n = scanner.nextInt();
		int[] list6 = new int[1000000];

		for (int i = 0; i < 1000000; i++) {
			list6[i] = i;
		}

		AtomicInteger count = new AtomicInteger(0);
		int index = binarySearch(n, list6, 0, list6.length - 1, count);
		System.out.printf("index=%d | count=%d\n",index,count.intValue());





	}

	private static int binarySearch(int value, int[] list, int i, int j, AtomicInteger count) {
		count.incrementAndGet();
		int k = (i + j) / 2;
		if (value == list[k]) {
			return k;
		} else if (value < list[k]) {
			return binarySearch(value, list, i, k,count);
		} else {
			return binarySearch(value, list, k + 1, j,count);
		}

	}
}
