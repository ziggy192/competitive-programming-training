package com.ziggy192.UVa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Uva10507 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner("6\n" +
//                "11\n" +
//                "HAB\n" +
//                "AB\n" +
//                "AC\n" +
//                "AH\n" +
//                "BD\n" +
//                "BC\n" +
//                "BF\n" +
//                "CD\n" +
//                "CF\n" +
//                "CH\n" +
//                "DF\n" +
//                "FH");
//        Scanner scanner = new Scanner("6\n" +
//                "11\n" +
//                "HAB\n" +
//                "AB\n" +
//                "AC\n" +
//                "AH\n" +
//                "BD\n" +
//                "BC\n" +
//                "BF\n" +
//                "CD\n" +
//                "CF\n" +
//                "CH\n" +
//                "DF\n" +
//                "FH\n" +
//                "\n" +
//                "5\n" +
//                "0\n" +
//                "ABZ\n" +
//                "\n" +
//                "5\n" +
//                "6\n" +
//                "ABC\n" +
//                "AD\n" +
//                "AE\n" +
//                "BD\n" +
//                "BE\n" +
//                "CD\n" +
//                "CE\n" +
//                "\n" +
//                "3\n" +
//                "0\n" +
//                "ABZ\n" +
//                "\n" +
//                "4\n" +
//                "0\n" +
//                "ATJ\n" +
//                "\n" +
//                "11\n" +
//                "12\n" +
//                "ABC\n" +
//                "AB\n" +
//                "BC\n" +
//                "CD\n" +
//                "BE\n" +
//                "AE\n" +
//                "AF\n" +
//                "AG\n" +
//                "AH\n" +
//                "AI\n" +
//                "AJ\n" +
//                "AK\n" +
//                "KJ\n" +
//                "\n" +
//                "8\n" +
//                "0\n" +
//                "TYJ\n" +
//                "\n" +
//                "10\n" +
//                "20\n" +
//                "ABC\n" +
//                "AB\n" +
//                "BC\n" +
//                "CD\n" +
//                "DE\n" +
//                "EF\n" +
//                "FG\n" +
//                "IJ\n" +
//                "FI\n" +
//                "IC\n" +
//                "DA\n" +
//                "BJ\n" +
//                "FJ\n" +
//                "AC\n" +
//                "DF\n" +
//                "HI\n" +
//                "HB\n" +
//                "GA\n" +
//                "GF\n" +
//                "BG\n" +
//                "CH\n" +
//                "\n" +
//                "6\n" +
//                "14\n" +
//                "ABC\n" +
//                "AB\n" +
//                "AC\n" +
//                "BC\n" +
//                "AD\n" +
//                "BD\n" +
//                "CD\n" +
//                "AE\n" +
//                "BE\n" +
//                "CE\n" +
//                "DE\n" +
//                "FB\n" +
//                "FC\n" +
//                "FD\n" +
//                "FE\n" +
//                "\n" +
//                "9\n" +
//                "16\n" +
//                "XYZ\n" +
//                "ZA\n" +
//                "AX\n" +
//                "BY\n" +
//                "BZ\n" +
//                "CX\n" +
//                "CY\n" +
//                "DZ\n" +
//                "YD\n" +
//                "XE\n" +
//                "ZE\n" +
//                "XY\n" +
//                "YZ\n" +
//                "ZX\n" +
//                "EF\n" +
//                "CA\n" +
//                "BD\n" +
//                "\n" +
//                "7\n" +
//                "12\n" +
//                "JOM\n" +
//                "PO\n" +
//                "PJ\n" +
//                "LM\n" +
//                "PM\n" +
//                "NO\n" +
//                "NP\n" +
//                "QP\n" +
//                "QN\n" +
//                "NM\n" +
//                "QJ\n" +
//                "LJ\n" +
//                "LP\n" +
//                "\n" +
//                "3\n" +
//                "0\n" +
//                "IUH\n" +
//                "\n" +
//                "6\n" +
//                "9\n" +
//                "ABC\n" +
//                "AD\n" +
//                "BD\n" +
//                "EC\n" +
//                "ED\n" +
//                "EA\n" +
//                "FE\n" +
//                "FA\n" +
//                "FB\n" +
//                "DC\n" +
//                "\n" +
//                "6\n" +
//                "9\n" +
//                "ABC\n" +
//                "AD\n" +
//                "BD\n" +
//                "CD\n" +
//                "EC\n" +
//                "ED\n" +
//                "EA\n" +
//                "FD\n" +
//                "FC\n" +
//                "FA\n");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // TODO: 7/31/19 iterator each input sets
            int n = Integer.parseInt(scanner.nextLine());
            int m = Integer.parseInt(scanner.nextLine());
            boolean[] checkAreanName = new boolean[26];
            boolean[] isAreaOn = new boolean[26];
            List<List<Integer>> linkedIndex = new ArrayList<List<Integer>>();
            for (int i = 0; i < 26; i++) {
                linkedIndex.add(new ArrayList<>());
            }
            for (char c : scanner.nextLine().toCharArray()) {
                checkAreanName[c-'A'] =true;
                isAreaOn[c - 'A'] = true;
            }

            for (int i = 0; i < m; i++) {
                char[] lineChars = scanner.nextLine().toCharArray();
                linkedIndex.get(lineChars[0] - 'A').add(lineChars[1]-'A');
                linkedIndex.get(lineChars[1] - 'A').add(lineChars[0]-'A');
                checkAreanName[lineChars[0] - 'A'] = true;
                checkAreanName[lineChars[1] - 'A'] = true;
            }

            // TODO: 7/31/19 process
            int countYears = 0;
            n = n - 3;
            while (n>0) {
                countYears++;
                List<Integer> nextAwaken = new ArrayList<>();

                for (int i = 0; i < 26; i++) {
                    if (!isAreaOn[i] && checkAreanName[i]) {
                        int count = 0;
                        for (Integer integer : linkedIndex.get(i)) {
                            if (isAreaOn[integer]) {
                                count ++;
                            }
                        }

                        if (count >= 3) {
                            nextAwaken.add(i);
                        }
                    }
                }

                for (Integer integer : nextAwaken) {
                    isAreaOn[integer] = true;
                    n--;
                }
                if (nextAwaken.isEmpty() || n<=0) {

                    break;
                }

            }

            boolean neverWakeup = false;
            for (int i = 0; i < 26; i++) {
                if (checkAreanName[i] && !isAreaOn[i]) {
                    // TODO: 7/31/19 never wakeup
                    neverWakeup = true;
                    break;
                }
            }
            if (neverWakeup || n>0) {
                System.out.println("THIS BRAIN NEVER WAKES UP");
            }else {
                System.out.println("WAKE UP IN, " + countYears + ", YEARS");
            }












            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

}
