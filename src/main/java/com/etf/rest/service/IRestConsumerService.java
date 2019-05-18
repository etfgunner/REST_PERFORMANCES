package com.etf.rest.service;

import java.util.List;

public interface IRestConsumerService {
    void test();

    List<Double> getStringObjectTimes();

    Double getStringObjectAsyncTime();

    List<Double> getSimpleObjectTimes();

    Double getSimpleObjectAsyncTime();

    List<Double> getComplexObjectTimes();

    Double getComplexObjectAsyncTime();

}
