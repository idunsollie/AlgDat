package org.pg4200.ex03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptimizedBubbleSortTest{

    private OptimizedBubbleSort sortClass; //Using OptimizeBubbeleSort to sort

    //For test with strings
    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }
    //For test with int
    private class IntegerComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    }

    //For test with double
    private class DoubleComparator implements Comparator<Double>{
        @Override
        public int compare(Double d1, Double d2) {
            return d1.compareTo(d2);
        }
    }

    //Make a new sortClass for each test
    @BeforeEach
    public void newSorter(){
        sortClass = new OptimizedBubbleSort();
    }

    //Check null test
    @Test
    public void checkNull(){
        sortClass.sort(null, new StringComparator(), false);
    }

    //String test
    @Test
    public void addAndSortOne(){
        String[] array = {"a"};

        sortClass.sort(array, new StringComparator(), false);

        assertEquals("a", array[0]);
    }
    @Test
    public void addAndSortMulti(){
        String[] array = {"a", "b", "c"};

        sortClass.sort(array, new StringComparator(), false);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
    }
    @Test
    public void addAndSortBackwards(){
        String[] array = {"e", "d", "c", "b", "a"};

        sortClass.sort(array,new StringComparator(), false);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);

    }
    @Test
    public void addAndSortMixed(){
        String[] array = {"e","d","b","c","a"};

        sortClass.sort(array, new StringComparator(), false);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);
    }
    @Test
    public void testOptimize(){

        String[] array = {"f", "a", "b", "c", "e", "d"};
        int optimizedTrue = sortClass.sort(array, new StringComparator(), true);
        //counter = 12

        array = new String[]{"f", "a", "b", "c", "e", "d"};
        int optimizedFalse = sortClass.sort(array, new StringComparator(), false);
        //counter = 15

        //Not the best way to check if its true
        assertTrue(optimizedTrue < optimizedFalse);
        assertEquals(optimizedTrue, 12);
        assertEquals(optimizedFalse, 15);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);
        assertEquals("f", array[5]);
    }

    @Test
    public void testOptimize2(){

        Integer[] array = {12,2,3,8,9,3,4};
        int optimizedTrue = sortClass.sort(array, new IntegerComparator(), true);
        //counter = 12

        array = new Integer[]{12,2,3,8,9,3,4};
        int optimizedFalse = sortClass.sort(array, new IntegerComparator(), false);
        //counter = 15

        //Not the best way to check if its true
        assertTrue(optimizedTrue < optimizedFalse);
        assertEquals(optimizedTrue, 18);

        assertEquals(2, array[0]);
        assertEquals(3, array[1]);
        assertEquals(3, array[2]);
        assertEquals(4, array[3]);
        assertEquals(8, array[4]);
        assertEquals(9, array[5]);
        assertEquals(12, array[6]);
    }

    @Test
    public void testOptimize3(){

        Integer[] array = {3,7,1,24,8,4,2,1,22};
        int optimizedTrue = sortClass.sort(array, new IntegerComparator(), true);
        //counter = 12

        array = new Integer[]{3,7,1,24,8,4,2,1,22};
        int optimizedFalse = sortClass.sort(array, new IntegerComparator(), false);
        //counter = 15

        //Not the best way to check if its true
        assertTrue(optimizedTrue < optimizedFalse);
        assertEquals(optimizedTrue, 30);

        assertEquals(0, array[0]);
        assertEquals(1, array[1]);
        assertEquals(2, array[2]);
        assertEquals(3, array[3]);
        assertEquals(4, array[4]);
        assertEquals(7, array[5]);
        assertEquals(8, array[6]);
        assertEquals(22, array[7]);
        assertEquals(24, array[8]);
    }

    //Test int
    @Test
    public void testInt(){
        Integer[] array = {3,5,1,2,7};
        sortClass.sort(array, new IntegerComparator(), false);

        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(5, array[3]);
        assertEquals(7, array[4]);

    }

    //Test Double
    @Test
    public void testDouble(){
        Double[] array = {2.3334, 1.2993, 1.1332, 6.2223, 0.823};
        sortClass.sort(array, new DoubleComparator(), false);

        assertEquals(0.823, array[0]);
        assertEquals(1.1332, array[1]);
        assertEquals(1.2993, array[2]);
        assertEquals(2.3334, array[3]);
        assertEquals(6.2223, array[4]);


    }

    //Test GameUser with only points
    @Test
    public void gameUserPoint(){
        GameUser g1 = new GameUser("theGodOfHorses", 101);
        GameUser g2 = new GameUser("youThinkYouKnow", 430);
        GameUser g3 = new GameUser("superElefant", 20);
        GameUser g4 = new GameUser("fastBanana", 456);

        GameUser[] array = {g1, g2, g3, g4 };

        sortClass.sort(array, new GameUserComparator(), false);

        assertEquals(20, array[0].getPoints());
        assertEquals(101, array[1].getPoints());
        assertEquals(430, array[2].getPoints());
        assertEquals(456, array[3].getPoints());
    }

    //Test GameUser with points and name
    @Test
    public void gameUserPointAndName(){

        GameUser g1 = new GameUser("theGodOfHorses", 101);
        GameUser g2 = new GameUser("youThinkYouKnow", 430);
        GameUser g3 = new GameUser("superElefant", 20);
        GameUser g4 = new GameUser("fastBanana", 430);

        GameUser[] array = {g1, g2, g3, g4 };

        System.out.println("Game user test: ");
        sortClass.sort(array, new GameUserComparator(), false);

        assertEquals("superElefant", array[0].getUserId());
        assertEquals("theGodOfHorses", array[1].getUserId());
        assertEquals("fastBanana", array[2].getUserId());
        assertEquals("youThinkYouKnow", array[3].getUserId());

        for(int i = 0; i < array.length; i++){
            System.out.println("Name of user: " + array[i].getUserId() + ", Points: " + array[i].getPoints());
        }

    }

}
