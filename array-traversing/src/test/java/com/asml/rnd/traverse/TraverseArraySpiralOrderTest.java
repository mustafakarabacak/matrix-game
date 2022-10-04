package com.asml.rnd.traverse;

import com.asml.rnd.traverse.arraytraverser.service.ArrayTraverser;
import com.asml.rnd.traverse.arraytraverser.service.impl.SpiralArrayTraverser;
import com.asml.rnd.traverse.arraytraverser.exception.TraverseException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;

public class TraverseArraySpiralOrderTest {
    private ArrayTraverser spiralArrayTraverser=
            new SpiralArrayTraverser();

    @Test
    public void traverseSpiralArrayTestFor4to4Matrix()
    {
        int [][] inputArr =  {
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };
        int [] expectedResult = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int [] actualResult =
                spiralArrayTraverser.traverseArray(inputArr);
                assertArrayEquals( expectedResult, actualResult );
    }

    @Test
    public void traverseSpiralArrayTestFor5to5Matrix()
    {
        int [][] inputArr =  {
                {0,1,2,3,4},
                {15,16,17,18,5},
                {14,23,24,19,6},
                {13,22,21,20,7},
                {12,11,10,9,8}
        };
        int [] expectedResult = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
                19,20,21,22,23,24};
        int [] actualResult =
                spiralArrayTraverser.traverseArray(inputArr);
        assertArrayEquals( expectedResult, actualResult );
    }

    @Test
    public void traverseSpiralArrayTestFor4to6Matrix()
    {
        int [][] inputArr =  {
                {0,1,2,3,4,5},
                {15,16,17,18,19,6},
                {14,23,22,21,20,7},
                {13,12,11,10,9,8},
        };
        int [] expectedResult = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
                19,20,21,22,23};
        int [] actualResult =
                spiralArrayTraverser.traverseArray(inputArr);
        assertArrayEquals( expectedResult, actualResult );
    }

    @Test
    public void traverseSpiralArrayTestFor6to4Matrix()
    {
        int [][] inputArr =  {
                {0,1,2,3},
                {15,16,17,4},
                {14,23,18,5},
                {13,22,19,6},
                {12,21,20,7},
                {11,10,9,8},
        };
        int [] expectedResult = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
                19,20,21,22,23};
        int [] actualResult =
                spiralArrayTraverser.traverseArray(inputArr);
        assertArrayEquals( expectedResult, actualResult );
    }

    @Test
    public void traverseSpiralArrayTestFor0to0Matrix()
    {
        int [][] inputArr =  {
        };
        int [] expectedResult = {};
        int [] actualResult =
                spiralArrayTraverser.traverseArray(inputArr);
        assertArrayEquals( expectedResult, actualResult );
    }

    @Test(expected = TraverseException.class)
    public void traverseSpiralArrayTestException()
    {
        int [][] inputArr =  {
                {1,2,3,4},
                {12,13,14,5},
                {11,15,6},
                {10,9,8,7}
        };
       spiralArrayTraverser.traverseArray(inputArr);
    }
}
