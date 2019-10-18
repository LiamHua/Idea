package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of points:");
        int num = input.nextInt();

        double[][] point = new double[num][3];
        System.out.print("Enter " + num + "points:");
        for(int i=0;i<num;i++)
            for(int k=0;k<3;k++)
                point[i][k] = input.nextDouble();

            double distanceMax = Math.sqrt((point[1][0]-point[0][0])*(point[1][0]-point[0][0]) + (point[1][1]-point[0][1])*(point[1][1]-point[0][1]) + (point[1][2]-point[0][2])*(point[1][2]-point[0][2]));
    }
}
