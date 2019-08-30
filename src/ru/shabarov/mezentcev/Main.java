package ru.shabarov;

import ru.shabarov.mezentcev.chapter01.Task1_7;
import ru.shabarov.mezentcev.chapter02.Task2_7;
import ru.shabarov.mezentcev.chapter04.Task4_6;
import ru.shabarov.mezentcev.chapter05.Task5_11;
import ru.shabarov.mezentcev.chapter06.Task6_7;
import ru.shabarov.mezentcev.chapter07.Task7_7;
import ru.shabarov.mezentcev.chapter08.Task8_11;
import ru.shabarov.mezentcev.chapter09.Task9_6;
import ru.shabarov.mezentcev.chapter11.Task11_8;

import java.util.*;

/**
 * Practice with Mezentcev A.V. 'Algorithm exercises' book
 */
public class Main {

    public static void main(String[] args) {

        //Chapter 01, Task 1.7
        System.out.println("Chapter 01 Task 1.7:");
        try {
            System.out.printf("Full path is %f, mean path is %f\n",
                    Task1_7.calculateFullPath(1, 4.0),
                    Task1_7.calculateMeanPath(1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Chapter 02, Task 2.7
        System.out.println("Chapter 02 Task 2.7:");
        System.out.printf("Calculated Series = %f, series for check = %f\n",
                Task2_7.calculateSeries(0.9),
                Task2_7.seriesCheck(0.9));

        //Chapter 03, Task 3.6
        /*
        System.out.println("Chapter 03 Task 3.6:");
        System.out.print("Please enter a number ('N' for finish): ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("N")){
            try{
                int n = scanner.nextInt();
                System.out.println();
                System.out.printf("Number %d is a Mersenn plain number - %s\n", n, Task3_6.isMersennNumber(n));
            }catch (InputMismatchException e){
                e.printStackTrace();
                String s = scanner.next();
                System.out.printf("Number %s is invalid. Please try again\n", s);
            }
        }
        */

        //Chapter 04, Task 4.6
        System.out.println("Chapter 04 Task 4.6:");
        final int[] a = {0, 2, 4, 6, 3, -1, 1};
        final int[] c = {3, -1, 1};
        System.out.printf("Array %s contains subsequence %s - %s\n",
                Arrays.toString(a), Arrays.toString(c), Task4_6.isSubSequence(a, c));

        //Chapter 05, Task 5.11
        System.out.println("Chapter 05 Task 5.11:");
        //final int[][] matrix = {{2,7,6}, {9,5,1}, {4,3,8}};
        final int[][] matrix = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        System.out.printf("Matrix is a magic - %s\n", Task5_11.isMagicMatrix(matrix));

        //Chapter 06, Task 6.7
        System.out.println("Chapter 06 Task 6.7");
        System.out.print(Task6_7.trimString(" Hello my   dear friend  "));
        System.out.println(".");

        //Chapter 07, Task 7.7
        System.out.println("Chapter 07 Task 7.7:");
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.printf("Initial array: %s, transformed array: %s\n", Arrays.toString(array),
                Arrays.toString(Task7_7.shiftArray2Right(array, 3)));

        //Chapter 08, Task 8.11
        System.out.println("Chapter 08 Task 8.11:");
        int[][] matrix1 = {{1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8},
                {4, 5, 6, 7, 8, 9},
                {5, 6, 7, 8, 9, 10},
                {6, 7, 8, 9, 10, 11}};

        System.out.printf("SUM is %d\n", Task8_11.calculateElementsSum(matrix1));

        //Chapter 09, Task 9.6
        System.out.println("Chapter 09 Task 9.6:");
        List<Double> l = new ArrayList<Double>();
        l.add(1.0);
        l.add(-3.2); // local min
        l.add(5.2);
        l.add(5.2);
        l.add(5.2);
        l.add(5.2);
        l.add(7.3);
        l.add(6.4);
        l.add(3.4); // local min
        l.add(4.4);
        l.add(4.1);
        l.add(4.1);
        l.add(4.1);
        l.add(4.0);
        l.add(3.0);
        l.add(2.0); // local min
        l.add(3.0);
        l.add(2.0);
        l.add(2.0);
        l.add(2.0);
        l.add(2.0);
        l.add(2.0);
        l.add(2.0);
        l.add(2.0);
        l.add(2.0);
        l.add(-6.0); // local min
        l.add(5.0);
        l.add(4.0);
        l.add(3.0);
        l.add(2.0);
        l.add(1.0);
        l.add(0.0);
        l.add(-1.0);
        l.add(-2.0);
        l.add(-3.0); // local min
        l.add(1.0);
        l.add(2.0);
        l.add(2.0);
        l.add(3.0);
        l.add(-4.0); // local min
        l.add(1.0);

        List<Double> shortestSequence = Task9_6.getShortestSequence(l);
        if(shortestSequence != null) {
            System.out.printf("Minimum sequence = %s\n", shortestSequence.toString());
        }
        else {
            System.out.println("Sequence has not found");
        }

        //Chapter 10, Task 10.8
        System.out.println("Chapter10 Task 10.8:");

        //Chapter 11, Task 11.8
        System.out.println("Chapter11 Task 11.8:");
        String phrase = "I recently switched jobs and now have \n" +
                "to work on a Java codebase. \n" +
                "I have ~5 years experience with C++ \n" +
                "code bases (used VIM or Visual Studio).\n" +
                "Right now I'm fairly a neeeeeeewbiiiiiiee to Java \n" +
                "as well as the IDEs for it. My team \n" +
                "mates seem to use IntelliJ but I found it a bit overwhelming.";
        System.out.printf("Longest word in a phrase is: %s", Task11_8.getLongestWord(phrase));
    }
}
