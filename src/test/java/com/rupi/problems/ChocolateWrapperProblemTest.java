package com.rupi.problems;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChocolateWrapperProblemTest {

    @Test
    public void shouldReturnZeroIfMoneyInHandIsZero(){
        MatcherAssert.assertThat(
                ChocolateWrapperProblem.maxChocolates(0, 10, 2),
                Is.is(0)
        );
    }

    @Test
    public void shouldReturnZeroIfMoneyInHandIsLessThanZero(){
        MatcherAssert.assertThat(
                ChocolateWrapperProblem.maxChocolates(-10, 10, 2),
                Is.is(0)
        );
    }

    @Test
    public void shouldReturnZeroIfMoneyInHandIsLessThanPriceOfChocolate(){
        MatcherAssert.assertThat(
                ChocolateWrapperProblem.maxChocolates(5, 10, 2),
                Is.is(0)
        );
    }

    @Test
    public void shouldReturnOneIfMoneyInHandIsEqualToPriceOfChocolateAndNumberOfWrappersRequiredIsGreaterThanOne(){
        MatcherAssert.assertThat(
                ChocolateWrapperProblem.maxChocolates(-10, 10, 2),
                Is.is(0)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfNumberOfWrappersRequiredIsLessThanTwo(){
        MatcherAssert.assertThat(
                ChocolateWrapperProblem.maxChocolates(1, 10, 1),
                Is.is(0)
        );
    }


    @Test
    public void firstPositiveCase(){
        MatcherAssert.assertThat(
                ChocolateWrapperProblem.maxChocolates(16, 2, 2),
                Is.is(15)
        );
    }

    @Test
    public void secondPositiveCase(){
        MatcherAssert.assertThat(
                ChocolateWrapperProblem.maxChocolates(16, 2, 3),
                Is.is(11)
        );
    }
}
