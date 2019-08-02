package com.ziggy192.uVA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uva00161 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner("19 20 0 \n" +
//                "30 \n" +
//                "25 35 0 \n" +
//                "30 58 62 32 31 32 22 64 89 90 \n" +
//                "10 27 10 29 56 35 28 \n" +
//                "45 56 58 \n" +
//                "29 28 54 78 58 96 32 10 28 35 \n" +
//                "36 98 75 32 54 85 96 \n" +
//                "32 42 45 \n" +
//                "10 27 77 88 28 62 52 35 53 90 \n" +
//                "50 51 52 53 56 55 56 57 58 59 \n" +
//                "60 61 62 63 64 65 66 67 68 69 \n" +
//                "70 71 72 73 74 75 76 77 \n" +
//                "78 79 \n" +
//                "80 81 82 83 84 85 86 87 88 89 \n" +
//                "90 31 32 33 34 35 36 37 38 41 \n" +
//                "0 \n" +
//                "10 10 0 \n" +
//                "11 10 12 13 14 0 \n" +
//                "10 11 12 13 14 15 16 17 18 19 20 0 \n" +
//                "10 26 0 \n" +
//                "42 87 88 90 0 \n" +
//                "53 54 55 68 20 \n" +
//                "0 \n" +
//                "50 51 52 53 54 55 56 25 \n" +
//                "18 0 \n" +
//                "56 90 10 25 32 64 58 52 0 \n" +
//                "0 0 0");
//        Scanner scanner = new Scanner("19 20 0\n" +
//                "30\n" +
//                "25 35 0\n" +
//                "0 0 0");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("0 0 0")) {
                return;
            }

            for (String s : line.split(" ")) {
                int num = Integer.parseInt(s);
                if (num != 0) {
                    list.add(num);
                } else {
                    // TODO: 7/16/19 run list
                    System.out.println(nextCollisionTime(list));
                    // TODO: 7/16/19 create new list
                    list = new ArrayList<>();
                }
            }
        }
    }

    private static String nextCollisionTime(List<Integer> list) {
        int minTime = -1;
        int[] greenTime = new int[list.size()];
        int[] cycleTime = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            greenTime[i] = list.get(i) - 5;
            cycleTime[i] = list.get(i) * 2;
            if (greenTime[i] < minTime || minTime == -1) {
                minTime = greenTime[i];
            }

        }

        int time = minTime - 1;
        while (time < 5 * 60 * 60) {

            time++;
            boolean correctTime = true;

            for (int i = 0; i < greenTime.length; i++) {
                if (time % cycleTime[i] < greenTime[i]) {
                    continue;
                }
                correctTime = false;
                break;
            }
            if (correctTime) {
                return String.format("%02d:%02d:%02d", time / 3600, time % 3600 / 60, time % 60);
            }
        }

        return "Signals fail to synchronise in 5 hours";
    }
}
