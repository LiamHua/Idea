package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter 10 numbers:");
        int[] num = new int[10];
        for(int i=0;i<10;i++)
            num[i] = input.nextInt();

        System.out.print("The output is:");
        for(int i=9;i>=0;i--)
            System.out.print(num[i]+" ");
        System.out.println();
    }
}
