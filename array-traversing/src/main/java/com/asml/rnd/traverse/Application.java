package com.asml.rnd.traverse;

import com.asml.rnd.traverse.arraytraverser.service.ArrayTraverser;
import com.asml.rnd.traverse.arraytraverser.service.impl.SpiralArrayTraverser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        Configurator.setLevel(logger,Level.DEBUG);
        ArrayTraverser spiralArrayTraverser=new SpiralArrayTraverser();
        int [][] inputArr =  {
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };
        int [] result = spiralArrayTraverser.traverseArray(inputArr);
        for (int index=0;index<result.length; index++) {
            logger.debug("{}. element of the array is {}", index, result[index]);
        }
    }
}
