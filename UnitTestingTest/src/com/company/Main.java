package com.company;

public class Main {

    public static void main(String[] args) {
        Utilities util = new Utilities();
        System.out.println(util.removePairs("AABCDDEFF"));

        System.out.println(util.removePairs("ABCCABDEEF"));

        char[] temp = {1,2,3,4,5,6};
        for (int i: util.everyNthChar(temp, 2)) {

            System.out.println(i);
        }

        System.out.println(util.nullIfOddLength(""));
        System.out.println(util.nullIfOddLength(null));
    }
}
