package ru.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.adapter.exception.ZeroException;
import ru.adapter.service.AdapterService;

/**
 * This @code{AdapterServiceTest} class tests @code{AdapterService} class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdapterServiceTest {

    @Autowired
    private AdapterService adapterService;

    @Test
    public void addTest(){
        Assert.assertTrue(adapterService.add(1,2) == 3);
        Assert.assertTrue(adapterService.add(10,20) == 30);
        Assert.assertTrue(adapterService.add(-10,-20) == -30);
        Assert.assertTrue(adapterService.add(-10,20) == 10);
        Assert.assertTrue(adapterService.add(-10,10) == 0);
    }

    @Test
    public void addTestWithZero(){
        Assert.assertTrue(adapterService.add(1,0) == 1);
        Assert.assertTrue(adapterService.add(0,1) == 1);
    }

    @Test
    public void divideTest(){
        Assert.assertTrue(adapterService.divide(2,1) == 2);
        Assert.assertTrue(adapterService.divide(1,1) == 1);
        Assert.assertTrue(adapterService.divide(1,2) == 0);
        Assert.assertTrue(adapterService.divide(15,3) == 5);
        Assert.assertTrue(adapterService.divide(-15,-3) == 5);
        Assert.assertTrue(adapterService.divide(-15,3) == -5);
        Assert.assertTrue(adapterService.divide(15,-3) == -5);
    }

    @Test
    public void divideTestWithZero(){
        Assert.assertThrows(ZeroException.class, () -> adapterService.divide(2,0));
        Assert.assertTrue(adapterService.divide(0,2) == 0);
    }

    @Test
    public void multiplyTest(){
        Assert.assertTrue(adapterService.multiply(1,2) == 2);
        Assert.assertTrue(adapterService.multiply(2,1) == 2);
        Assert.assertTrue(adapterService.multiply(10,10) == 100);
        Assert.assertTrue(adapterService.multiply(-10,-10) == 100);
        Assert.assertTrue(adapterService.multiply(-10,10) == -100);
        Assert.assertTrue(adapterService.multiply(10,-10) == -100);
    }

    @Test
    public void multiplyTestWithZero(){
        Assert.assertTrue(adapterService.multiply(1,0) == 0);
        Assert.assertTrue(adapterService.multiply(0,1) == 0);
    }

    @Test
    public void subtractTest(){
        Assert.assertTrue(adapterService.subtract(1,1) == 0);
        Assert.assertTrue(adapterService.subtract(1,2) == -1);
        Assert.assertTrue(adapterService.subtract(2,1) == 1);
        Assert.assertTrue(adapterService.subtract(2,-1) == 3);
        Assert.assertTrue(adapterService.subtract(-20,10) == -30);
        Assert.assertTrue(adapterService.subtract(-20,-10) == -10);
    }

    @Test
    public void subtractTestWithZero(){
        Assert.assertTrue(adapterService.subtract(1,0) == 1);
        Assert.assertTrue(adapterService.subtract(0,1) == -1);
    }

}
