package ru.adapter;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.test.context.junit4.SpringRunner;
import ru.adapter.service.AdapterService;

import static org.junit.Assert.assertEquals;

/**
 * This @code{CachingTest} class tests for cashing.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CachingTest {

    @Autowired
    private AdapterService adapterService;

    @Autowired
    CacheManager cacheManager;

    @BeforeAll
    void setUp() {
        adapterService.add(1,1);
        adapterService.divide(1,1);
        adapterService.multiply(1,1);
        adapterService.subtract(1,1);

    }

    @Test
    public void addTest(){
        adapterService.add(1,1);
        assertEquals(2,cacheManager.getCache("add").get(new SimpleKey(1,1)).get());
    }

    @Test
    public void divideTest(){
        adapterService.divide(1,1);
        assertEquals(1,cacheManager.getCache("divide").get(new SimpleKey(1,1)).get());
    }

    @Test
    public void multiplyTest(){
        adapterService.multiply(1,1);
        assertEquals(1,cacheManager.getCache("multiply").get(new SimpleKey(1,1)).get());
    }

    @Test
    public void subtractTest(){
        adapterService.subtract(1,1);
        assertEquals(0,cacheManager.getCache("subtract").get(new SimpleKey(1,1)).get());
    }




}
