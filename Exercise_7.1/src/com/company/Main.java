package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students:");
        int number = input.nextInt();

        System.out.print("Enter " + number + " scores:");
        int[] score = new int[number];

        for(int i=0;i<score.length;i++)
            score[i] = input.nextInt();

        int best = score[0];
        for(int i=1;i<score.length;i++)
        {
            if(best<score[i])
            best = score[i];
        }

        char[] grade = new char[number];
        for(int i=0;i<score.length;i++)
        {
            if(score[i] >= best-10)
                grade[i] = 'A';
            else if(score[i] >=best-20)
                grade[i] = 'B';
            else if(score[i] >= best-30)
                grade[i] = 'C';
            else if(score[i] >= best-40)
                grade[i] = 'D';
            else
                grade[i] = 'F';
        }
        for(int i=0;i<score.length;i++)
            System.out.println("Student " + i +" score is "+score[i] + " and grade is " + grade[i]);
    }
}
