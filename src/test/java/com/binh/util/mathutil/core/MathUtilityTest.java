package com.binh.util.mathutil.core;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MathUtilityTest {
    @Test
    public void testAdd(){
        MathUtility utility = new MathUtility();

        assertEquals(utility.add(2,4),5);
    }

    @Test
    public void testAdd1(){
        MathUtility utility = new MathUtility();

        assertEquals(utility.add(2,4),6);
    }
    @Test
    public void testAdd2(){
        MathUtility utility = new MathUtility();

        assertEquals(utility.add(2,4),6);
    }
    @Test
    public void testAdd3(){
        MathUtility utility = new MathUtility();

        assertEquals(utility.add(2,4),5);
    }

}