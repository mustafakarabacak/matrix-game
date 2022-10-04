package com.asml.rnd.traverse.arraytraverser.service.impl;

import com.asml.rnd.traverse.arraytraverser.exception.TraverseException;
import com.asml.rnd.traverse.arraytraverser.service.ArrayTraverser;

/**
 * <h2> Traversion of an array </h2>
 * This class includes implementation of traversion of a 2D array.
 *
 * @author mustafa
 *
 */
public class SpiralArrayTraverser implements ArrayTraverser {

    /**
     * Returns a flat array that consists of elements of a given 2d array in
     * spiral order.
     *
     * @param  inputArray  a proper 2d array to traverse
     * @return      flat array with an elements of given 2d array ordered
     * spirally
     * @exception TraverseException if the array has differents element count
     * in each row. All the rows must have same number of elements.
     */
    public int[] traverseArray(int [][] inputArray) throws TraverseException {
        int [] result = new int[findTotalArrayLength(inputArray)];
        if(result.length==0) {
            return result;
        }
        //start and end points of rows-columns
        int rowFirstIndexToTraverse=0;
        int rowLastIndexToTraverse= inputArray[0].length-1;
        int columnFirstIndexToTraverse=1;
        int columnLastIndexToTraverse= inputArray.length-1;

        boolean isCurrentlyOnRowToTraverse=true;
        int whichRowOrColumnWeAreOn=0;
        int currentIndexToPrint=rowFirstIndexToTraverse;

        for(int counter=0;counter<findTotalArrayLength(inputArray);counter++) {
            if(isCurrentlyOnRowToTraverse){
                result[counter]=
                        (inputArray[whichRowOrColumnWeAreOn][currentIndexToPrint]);

                if (currentIndexToPrint==rowLastIndexToTraverse){
                    whichRowOrColumnWeAreOn=rowLastIndexToTraverse;
                    int temp = rowFirstIndexToTraverse;
                    rowFirstIndexToTraverse = getFirstIndexToTraverse(rowFirstIndexToTraverse, rowLastIndexToTraverse);
                    rowLastIndexToTraverse=temp;
                    isCurrentlyOnRowToTraverse=false;
                    currentIndexToPrint=columnFirstIndexToTraverse;
                }
                else {
                    currentIndexToPrint=
                            getCurrentIndexToPrint(rowLastIndexToTraverse, currentIndexToPrint);
                }
            }
            else{
                result[counter] =
                        (inputArray[currentIndexToPrint][whichRowOrColumnWeAreOn]);

                if (currentIndexToPrint==columnLastIndexToTraverse){
                    whichRowOrColumnWeAreOn=columnLastIndexToTraverse;
                    int temp = columnFirstIndexToTraverse;
                    columnFirstIndexToTraverse = getFirstIndexToTraverse(columnFirstIndexToTraverse, columnLastIndexToTraverse);
                    columnLastIndexToTraverse=temp;
                    isCurrentlyOnRowToTraverse=true;
                    currentIndexToPrint=rowFirstIndexToTraverse;
                }
                else {
                    currentIndexToPrint =
                            getCurrentIndexToPrint(columnLastIndexToTraverse, currentIndexToPrint);
                }
            }
        }
        return result;
    }

    private int getFirstIndexToTraverse(int columnFirstIndexToTraverse, int columnLastIndexToTraverse) {
        columnFirstIndexToTraverse =
                columnLastIndexToTraverse > columnFirstIndexToTraverse ?
                        columnLastIndexToTraverse - 1 :
                        columnLastIndexToTraverse + 1;
        return columnFirstIndexToTraverse;
    }

    private int getCurrentIndexToPrint(int lastIndexToTraverse,
                                    int currentIndexToPrint) {
        if (currentIndexToPrint < lastIndexToTraverse) {
            currentIndexToPrint +=1;
        }
        else if(currentIndexToPrint > lastIndexToTraverse){
            currentIndexToPrint -=1;
        }
        return currentIndexToPrint;
    }

    /**
     * Calculates the total length of a 2D array.
     *
     * @param inputArray 2D array to be counted.
     * @exception TraverseException if the array has differents element count
     * in each row. All the rows must have same number of elements.
     */
    private static int findTotalArrayLength(int [][] inputArray) throws TraverseException{
        int result = 0;
        for (int row=0;row<inputArray.length;row++)
        {
            if(inputArray[row].length!=inputArray[0].length)
            {
                throw new TraverseException("Array must have same number of " +
                        "elements in each row");
            }
            result+=inputArray[row].length;
        }
        return result;
    }
}
