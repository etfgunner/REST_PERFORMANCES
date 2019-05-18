package com.etf.rest.service;

import com.etf.rest.connector.IRestClient;
import com.etf.rest.model.ComplexModel;
import com.etf.rest.model.SimpleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class RestConsumerService implements IRestConsumerService {

    private static final int NUMBER_OF_ITERATIONS = 100;
    private static final double MS = 1000000.0;

    @Autowired
    IRestClient restClient;

    @Override
    public void test() {
        restClient.test();
    }

    @Override
    public List<Double> getStringObjectTimes() {
        List<Double> serviceCallsDurations = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            long startTime = System.nanoTime();
            restClient.getString();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            serviceCallsDurations.add(totalTime / MS);
        }
        return serviceCallsDurations;
    }

    @Override
    public Double getStringObjectAsyncTime() {
        List<Integer> iterations = IntStream.of(new int[NUMBER_OF_ITERATIONS])
                .boxed()
                .collect(Collectors.toList());
        long startTime = System.nanoTime();
        iterations.parallelStream()
                .map(iteration -> getStringsAsync())
                .collect(Collectors.toList());
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime / MS;
    }

    @Override
    public List<Double> getSimpleObjectTimes() {
        List<Double> serviceCallsDurations = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            long startTime = System.nanoTime();
            restClient.getSimpleObject();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            serviceCallsDurations.add(totalTime / MS);
        }
        return serviceCallsDurations;
    }

    @Override
    public Double getSimpleObjectAsyncTime() {
        List<Integer> iterations = IntStream.of(new int[NUMBER_OF_ITERATIONS])
                .boxed()
                .collect(Collectors.toList());
        long startTime = System.nanoTime();
        iterations.parallelStream()
                .map(iteration -> getSimpleObjectAsync())
                .collect(Collectors.toList());
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime / MS;
    }

    @Override
    public List<Double> getComplexObjectTimes() {
        List<Double> serviceCallsDurations = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            long startTime = System.nanoTime();
            restClient.getComplexObject();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            serviceCallsDurations.add(totalTime / MS);
        }
        return serviceCallsDurations;
    }

    @Override
    public Double getComplexObjectAsyncTime() {
        List<Integer> iterations = IntStream.of(new int[NUMBER_OF_ITERATIONS])
                .boxed()
                .collect(Collectors.toList());
        long startTime = System.nanoTime();
        iterations.parallelStream()
                .map(iteration -> getComplexObjectAsync())
                .collect(Collectors.toList());
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime / MS;
    }

    private CompletableFuture<String> getStringsAsync() {
        return CompletableFuture.supplyAsync(() -> restClient.getString())
                .exceptionally(x -> {
                    System.out.print(x.getLocalizedMessage());
                    return null;
                });
    }

    private CompletableFuture<SimpleModel> getSimpleObjectAsync() {
        return CompletableFuture.supplyAsync(() -> restClient.getSimpleObject())
                .exceptionally(x -> {
                    System.out.print(x.getLocalizedMessage());
                    return null;
                });
    }

    private CompletableFuture<ComplexModel> getComplexObjectAsync() {
        return CompletableFuture.supplyAsync(() -> restClient.getComplexObject())
                .exceptionally(x -> {
                    System.out.print(x.getLocalizedMessage());
                    return null;
                });
    }
}
