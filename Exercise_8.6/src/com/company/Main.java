package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String ch ="  ";
        System.out.print("Please Enter the First Matrix:");
        double[][] Matrix_1 = initMatrix();

        System.out.print("Please Enter the Second Matrix:");
        double[][] Matrix_2 = initMatrix();

        double[][] Matrix_3 = multiplyMatrix(Matrix_1,Matrix_2);

        System.out.println("The multiplication of the matrices is:");
        for(int i=0;i<3;i++)
        {
            for(int k=0;k<3;k++)
                System.out.print(Matrix_1[i][k] + " ");

            if(i==1)
                System.out.print("   *   ");
            else
                System.out.print("       ");

            for(int k=0;k<3;k++)
                System.out.print(Matrix_2[i][k] + " ");
            if(i==1)
                System.out.print("   =   ");
            else
                System.out.print("       ");

            for(int k=0;k<3;k++)
                System.out.format("%.1f  ",Matrix_3[i][k]);

            System.out.println();
        }

    }

    public static double[][] initMatrix()
    {
        Scanner input = new Scanner(System.in);
        double[][] Matrix = new double[3][3];
        for(int i=0;i<3;i++)
            for(int k=0;k<3;k++)
                Matrix[i][k] = input.nextDouble();
        return Matrix;
    }

    public static double[][] multiplyMatrix(double[][] a,double[][] b)
    {
        double[][] c = new double[3][3];
        for(int i=0;i<3;i++)
            for(int k=0;k<3;k++)
                c[i][k] = a[i][0]*b[0][k] + a[i][1]*b[1][k] + a[i][2]*b[2][k];
            return c;
    }
}
