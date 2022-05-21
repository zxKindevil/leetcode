package com.example.springbootdemo;

import java.awt.event.ItemEvent;

public class Leet_0135 {
    public static int[] test1 = new int[]{3, 3, 8, 7, 4, 5, 9, 3, 4, 55};//weikou
    public static int[] test2 = new int[] {1,0,2};
    public static int[] test3 = new int[] {1,2,2};
    public static int[] test4 = new int[] {1,3,2,2,1};
    public static int[] test5 = new int[] {1,2,87,87,87,2,1};
    public static int[] test6 = new int[] {1,2,87,10,9,8,1};
    //todo，判断一个连续区间，如果递增和递减在一起，并相等，需要特别判断


    public static void main(String[] args) {
//        //printArray(test1);
//        int index = findMaxSequence(test1);
//        fillCandy(index, test1);

        //System.out.println(new Leet_0135().candy(test1));
//        System.out.println(new Leet_0135().candy(test4));
        //System.out.println(new Leet_0135().candy(test3));


        int minIndex = findMaxSequence(test5);
        System.out.println(minIndex);
        int[] candies = fillCandy(minIndex, test5);
        printArray(candies);
        System.out.println(sumArray(candies));
    }

    public int candy(int[] ratings) {
        int minIndex = findMaxSequence(ratings);
        int[] candies = fillCandy(minIndex, ratings);
        return sumArray(candies);
    }

    public static int findMaxSequence(int[] ratings) {
        int sequence = 1;
        int maxContinue = 1;
        int minIndex = 0;
        int lastIndex = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                sequence += 1;
            } else {
                if (sequence > maxContinue) {
                    maxContinue = sequence;
                    minIndex = lastIndex;
                }
                sequence = 1;
                lastIndex = i;
            }
        }
        if (sequence > maxContinue) {
            maxContinue = sequence;
            minIndex = lastIndex;
        }

        //reverse
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] <= ratings[i - 1]) {
                sequence += 1;
            } else {
                if (sequence > maxContinue) {
                    maxContinue = sequence;
                    minIndex = i-1;
                }
                sequence = 1;
                lastIndex = i;
            }
        }
        if (sequence > maxContinue) {
            maxContinue = sequence;
            minIndex = ratings.length -1;
        }

        return minIndex;
    }

    public static int[] fillCandy(int start, int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[start] = 1;

        if(start != ratings.length -1) {
            for (int i = start +1; i < ratings.length; i++) {
                if (ratings[i] <= ratings[i - 1]) {
                    candies[i] = 1;
                } else {
                    candies[i] = candies[i-1]+1;
                }
            }
        }

        if(start != 0) {
            for (int j = start -1; j >=0; j--) {
                if (ratings[j] > ratings[j + 1]) {
                    candies[j] = candies[j+1] +1;
                } else {
                    candies[j] = 1;
                }
            }
        }

        //printArray(candies);
        return candies;
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        //System.out.println(sum);
        return sum;
    }

    public static void printArray(int[] arr){
        for (int item : arr) {
            System.out.print(item+ ",");
        }
        System.out.println();
    }

}
