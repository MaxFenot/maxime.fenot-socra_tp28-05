package com.epita.socra.app;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epita.socra.app.tools.IOAdapter;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void givenAMock_WhenRunningMain_ThenCheckOuputs_42() {
        IOAdapter mock = mock(IOAdapter.class);
/*        when(mock.read()).thenReturn("TEST");
        App app = new App(mock);
        app.run();

        verify(mock).write("Hello, what's your name ?");
        verify(mock).write(argThat(message -> message.contains("TEST")));
*/

        when(mock.read()).thenReturn("42");
        App app = new App(mock);
        app.run();
        verify(mock).write("Enters input: ");
        verify(mock).write(argThat(message -> message.contains("...-..---")));
    }

    @Test
    public void givenAMock_WhenRunningMain_ThenCheckOuputs_999() {
        IOAdapter mock = mock(IOAdapter.class);

        when(mock.read()).thenReturn("999");
        App app = new App(mock);
        app.run();
        verify(mock).write("Enters input: ");
        verify(mock).write(argThat(message -> message.contains("----.----.----.")));
    }

    @Test
    public void givenAMock_WhenRunningMain_ThenCheckOuputs_InvalidInput_abc() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("abc");
        App app = new App(mock);
        app.run();
        verify(mock).write("Enters input: ");
        verify(mock).write(argThat(message -> message.contains("Invalid input !")));
    }

    @Test
    public void givenAMock_WhenRunningMain_ThenCheckOuputs_InvalidInput_neg1() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("-1");
        App app = new App(mock);
        app.run();
        verify(mock).write("Enters input: ");
        verify(mock).write(argThat(message -> message.contains("Invalid input !")));
    }
}
