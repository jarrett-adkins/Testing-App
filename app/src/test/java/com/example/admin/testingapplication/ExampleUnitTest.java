package com.example.admin.testingapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ExampleUnitTest {

    Calculation c;
    private int val1;
    private int val2;
    public static final String ADDITION_STRING = "addition";
    public static final String CALCULATION_STRING = "calculation";

    // The addition class is a dependency.
    Addition a;


    @Before
    public void setup() {
        // the annotation means this will be called before test cases. Do initialization here.

        a = mock( Addition.class );
        c = new Calculation( a );
        val1 = 5;
        val2 = 10;
        c.setVal1(val1);
        c.setVal2(val2);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(15, c.addition());
    }

    @Test
    public void addTen_isCorrect() throws Exception {
        // we don't care what it actually returns, just arbitrarily tell it to return something.
        // imagine testing a json parser when you don't have internet. Without when() it will return
        // zero, because the object is mocked.
        when( a.add( val1, val2 )).thenReturn(5);
        assertEquals(15, c.addTen());
    }

    @Test
    public void someString_test() {
        when( a.additionString( ADDITION_STRING ))
                .thenAnswer(new Answer<String>() {
                    @Override
                    public String answer(InvocationOnMock invocation) throws Throwable {
                        return "some";
                    }
                });

        assertEquals("some" + CALCULATION_STRING, c.someString( ADDITION_STRING, CALCULATION_STRING ));
    }

    @After
    public void tearDown() {
        c.clear();
    }
}