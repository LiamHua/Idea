package com.company;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount:");
        double amount = input.nextDouble();

        System.out.print("Enter annual interest rate in percentage:");
        double percentage = input.nextDouble();

        System.out.print("Enter number of years:");
        int years = input.nextInt();

        double value_0 = pow(1+percentage/1200,years*12);
        double value = amount*value_0;
        System.out.format("%s%.2f","Accumulated value is $",value);
    }
}
