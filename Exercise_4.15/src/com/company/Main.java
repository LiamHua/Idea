package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Enter a letter:");
            String s = input.nextLine();

            char ch = s.charAt(0);
            int output = 0;

            if(((int)ch>=65&&(int)ch<=90)||((int)ch>=97&&(int)ch<=122))
            {
                if (ch == 'a' || ch == 'b' || ch == 'c' || ch == 'A' || ch == 'B' || ch == 'C')
                    output = 2;

                else if (ch == 'd' || ch == 'e' || ch == 'f' || ch == 'D' || ch == 'E' || ch == 'F')
                    output = 3;

                else if (ch == 'g' || ch == 'h' || ch == 'i' || ch == 'G' || ch == 'H' || ch == 'I')
                    output = 4;

                else if (ch == 'j' || ch == 'k' || ch == 'l' || ch == 'J' || ch == 'K' || ch == 'L')
                    output = 5;

                else if (ch == 'm' || ch == 'n' || ch == 'o' || ch == 'M' || ch == 'N' || ch == 'O')
                    output = 6;

                else if (ch == 'p' || ch == 'q' || ch == 'r' || ch == 's' || ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S')
                    output = 7;

                else if (ch == 't' || ch == 'u' || ch == 'v' || ch == 'T' || ch == 'U' || ch == 'V')
                    output = 8;

                else if (ch == 'w' || ch == 'x' || ch == 'y' || ch == 'z' || ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z')
                    output = 9;

                System.out.println("The corresponding number is " + output);
            }
            else
                System.out.println(ch+" is an invalid input");
        }
    }
}
