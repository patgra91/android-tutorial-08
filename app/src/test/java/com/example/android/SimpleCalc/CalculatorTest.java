/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        //assertThat(resultAdd, is(equalTo(2.222d)));
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }

    ////
    @SmallTest
    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(2d, 1d);
        assertThat(resultSub, is(equalTo(1d)));
    }

    @Test
    public void subWorksWithNegativeResults() {
        double resultSub = mCalculator.sub(2d, 3d);
        assertThat(resultSub, is(equalTo(-1d)));
    }

    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(2d, 2d);
        assertThat(resultMul, is(equalTo(4d)));
    }

    @Test
    public void mulTwoNumbersZero() {
        double resultMul = mCalculator.mul(9d, 0d);
        assertThat(resultMul, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(5d, 2d);
        assertThat(resultDiv, is(equalTo(2.5d)));
    }

    /*
    @Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(5d, 0d);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }
    */

    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows() throws Exception {
        double resultDiv = mCalculator.div(3d, 0d);
    }

    ////

    @Test
    public void powPositiveNumbers() {
        double rPow = mCalculator.pow(2d, 4d);
        assertThat(rPow, is(equalTo(16d)));
    }

    @Test
    public void powFirstNegative() {
        double rPow = mCalculator.pow(-2d,3d);
        assertThat(rPow, is(equalTo(-8d)));
    }

    @Test
    public void powSecondNegative() {
        double rPow = mCalculator.pow(2d, -3d);
        assertThat(rPow, is(equalTo(1d/(Math.pow(2d, 3d)))));
    }

    @Test
    public void powFirstZeroSecondPositive() {
        double rPow = mCalculator.pow(0d,2d);
        assertThat(rPow, is(equalTo(0d)));
    }

    @Test
    public void powSecondZero() {
        double rPow = mCalculator.pow(2d, 0d);
        assertThat(rPow, is(equalTo(1d)));
    }

    @Test
    public void powZeroNegativeOne() {
        double rPow = mCalculator.pow(0d, -1);
        //assertThat(rPow, is(equalTo(0d)));
        assertThat(rPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powNegZeroNegNumber() {
        double rPow = mCalculator.pow(-0, -2);
        //assertThat(rPow, is(equalTo(0d)));
        assertThat(rPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }


}