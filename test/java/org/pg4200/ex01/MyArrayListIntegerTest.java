package org.pg4200.ex01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyArrayListIntegerTest {

    private MyArrayListInteger data;

    @BeforeEach
    public void integerTest(){
        data = new MyArrayListInteger(10);
    }

    @Test
    public void testEmpty(){
        assertEquals(0,data.size());
    }

    @Test
    public void testAddOneInteger(){
        int count = data.size();
        data.add(2);

        assertEquals(count +1, data.size());
    }

    @Test
    public void testAddAndRetrieveInteger(){
        int value = 2;

        data.add(value);

        int res = data.get(0);

        assertEquals(value,res);
    }

    @Test
    public void testAdd5Integer(){
        assertEquals(0, data.size());

        int a = 2;
        int b = 4;
        int c = 7;

        data.add(a);
        data.add(b);
        data.add(c);
        data.add(a);
        data.add(a);

        assertEquals(a, data.get(0));
        assertEquals(b, data.get(1));
        assertEquals(c, data.get(2));
        assertEquals(a, data.get(3));
        assertEquals(a, data.get(4));
    }

    @Test
    public void testOutOfIndex(){
        assertNull(data.get(-3));
        assertNull(data.get(30));
    }


}
