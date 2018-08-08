package operations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd() {
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0, 20.0)).thenReturn(30.00);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);


        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);



        //test the add functionality
                Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

        //verify call to calcService is made or not with same arguments.
        //verify(calcService).add(10.0, 20.0);

        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //limit the method call to 1, no less and no more calls are allowed
        verify(calcService, times(1)).add(10.0, 20.0);

        //check a minimum 1 call count
        verify(calcService, atLeastOnce()).subtract(20.0, 10.0);

        //check if add function is called minimum 2 times
                verify(calcService, atLeast(2)).add(10.0, 20.0);

        //check if add function is called maximum 3 times
                verify(calcService, atMost(3)).add(10.0,20.0);

//add the behavior to throw exception
        doThrow(new RuntimeException("divide operation not implemented"))
                .when(calcService).add(10.0,20.0);


        //reset mock
        reset(calcService);


    }
}

