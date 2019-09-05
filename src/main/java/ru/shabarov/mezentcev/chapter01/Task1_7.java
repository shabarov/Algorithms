package ru.shabarov.mezentcev.chapter01;

/**
 * Created by Mikhail on 07.09.2016.
 */

/*
    Calculate the total path made by a moving body for a N seconds.
    On the 1-st second it gets P path,
    On the 2-nd second it gets Psqrt(2)+1,
    Ob the 3-rd second it gets Psqrt(2)+2, etc.
    Calculate a mean path for a one second.
 */
public class Task1_7 {

    private static int n = 0;
    private static double fullPath = -1D;
    public static double calculateFullPath(int secondsNum, double firstSecondPath) throws IllegalArgumentException {

        if(secondsNum < 1) throw new IllegalArgumentException("Number of seconds less than 1");
        if(firstSecondPath < 0) throw new IllegalArgumentException("First second path less than 0");

        fullPath = calculateFullPathReccursively(secondsNum, firstSecondPath);

        return fullPath;

    }

    public static double calculateMeanPath(int secondsNum) throws Exception {
        if(fullPath == -1D) throw new Exception("Please calculate full path first");
        if(secondsNum < 1) throw new IllegalArgumentException("Number of seconds less than 1");

        return fullPath / secondsNum;
    }

    private static double calculateFullPathReccursively(int second, double path){
        double p = path * Math.sqrt(second) + second - 1;
        if (Double.compare(p, path) < 1){
            return path;
        }
        return calculateFullPathReccursively(second - 1, path) + p;
    }
}
