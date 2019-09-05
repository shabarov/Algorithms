package ru.shabarov.mezentcev.chapter09;

import java.util.List;

/**
 * Created by Mikhail on 10.09.2016.
 */
public class Task9_6 {

    private static int minSequenceStartIndex = -1;
    private static int minSequenceEndIndex = -1;
    private static int lastMinimumIndex = -1;


    public static List<Double> getShortestSequence(List<Double> a){
        if(a.size() <= 3) throw new IllegalArgumentException("Sequence must have more than 3 elements");

        Double extraPrevElement = a.get(0);
        Double prevElement = a.get(1);

        if(extraPrevElement == null || prevElement == null) throw new IllegalArgumentException("First and second elements must be not null");

        for(int i = 2; i < a.size(); i++){
            Double element = a.get(i);
            if(isMinimum(extraPrevElement, prevElement, element)){
                if(lastMinimumIndex != -1){
                    if(!isAtLeastOneSequenceFound() || isMinimumSequence(i)){
                        minSequenceStartIndex = lastMinimumIndex;
                        minSequenceEndIndex = i - 2;
                    }
                }
                lastMinimumIndex = i;
            }
            extraPrevElement = prevElement;
            prevElement = element;
        }
        if (!isAtLeastOneSequenceFound()) return null;

        return a.subList(minSequenceStartIndex, minSequenceEndIndex + 1);
    }

    private static boolean isMinimum(Double first, Double second, Double third){
        return (first > second) && (third > second);
    }
    private static boolean isAtLeastOneSequenceFound(){
        return minSequenceStartIndex != -1 && minSequenceEndIndex != -1;
    }
    private static boolean isMinimumSequence(int index){
        return (index - 2 - lastMinimumIndex) < (minSequenceEndIndex - minSequenceStartIndex);
    }
}
