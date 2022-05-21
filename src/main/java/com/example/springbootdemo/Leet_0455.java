package com.example.springbootdemo;


import java.util.Arrays;

public class Leet_0455 {

    public static void main(String[] args) {
        int[] g = new int[]{10,9,8,7};//weikou

        int[] s  = {5,6,7,8};

        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(g, s));
    }


}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int[] children = g;
        int[] cookies = s;
        Arrays.sort(children);
        Arrays.sort(cookies);

        int indexChild,indexCookie;
        int count = 0;
        for (indexChild = 0,indexCookie = 0; indexChild < children.length && indexCookie < cookies.length; ) {
            if(cookies[indexCookie] < children[indexChild]){
                indexCookie++;
                continue;
            }
            indexCookie++;
            indexChild++;
            count++;
        }

        return count;

    }

    public static void prints(int arr[]) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
