package com.etf.rest;

import com.etf.rest.service.IRestConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApplicationTests {

    @Autowired
    IRestConsumerService restConsumerService;

    @Test
    public void test() {
        restConsumerService.test();
    }

    @Test
    public void stringTimingTest() {
        File file = new File("RESTExecutionTimesString.txt");
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            restConsumerService.getStringObjectTimes()
                    .stream()
                    .forEach(x -> {
                        try {
                            writer.write(x.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringAsyncTimingTest() {
        File file = new File("RESTExecutionTimesStringAsync.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            Double executionTime = restConsumerService.getStringObjectAsyncTime();
            writer.write(executionTime.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleObjectTimingTest() {
        File file = new File("RESTExecutionTimesSimpleObject.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            restConsumerService.getSimpleObjectTimes()
                    .stream()
                    .forEach(x -> {
                        try {
                            writer.write(x.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleObjectAsyncTimingTest() {
        File file = new File("RESTExecutionTimeSimpleObjectAsync.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            Double executionTime = restConsumerService.getSimpleObjectAsyncTime();
            writer.write(executionTime.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void complexObjectTimingTest() {
        File file = new File("RESTExecutionTimesComplexObject.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            restConsumerService.getComplexObjectTimes()
                    .stream()
                    .forEach(x -> {
                        try {
                            writer.write(x.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void complexObjectAsyncTimingTest() {
        File file = new File("RESTExecutionTimeComplexObjectAsync.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            Double executionTime = restConsumerService.getComplexObjectAsyncTime();
            writer.write(executionTime.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
