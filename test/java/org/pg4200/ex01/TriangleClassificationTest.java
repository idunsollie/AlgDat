package org.pg4200.ex01;

import org.junit.jupiter.api.Test;

import org.pg4200.ex01.TriangleClassification.Classification;
import static org.pg4200.ex01.TriangleClassification.Classification.*;
import static org.pg4200.ex01.TriangleClassification.classify;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleClassificationTest {


    @Test
    public void testNegativeValue(){
        Classification test = classify(-5,6,4);
        assertEquals(NOT_A_TRIANGLE,test);
    }

    @Test
    public void testEquilateral(){
        Classification test = classify(5,5,5);
        assertEquals(EQUILATERAL, test);
    }

    @Test
    public void testIsosceles(){
        Classification test = classify(4,5,4);
        assertEquals(ISOSCELES,test);
    }
    @Test
    public void testScalene(){
        Classification test = classify(3,7,5);
        assertEquals(SCALENE,test);
    }
    @Test
    public void toLongEdge(){
        Classification test = classify(3,500,3);
        assertEquals(NOT_A_TRIANGLE,test);
    }


}
