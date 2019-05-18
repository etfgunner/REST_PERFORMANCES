package com.etf.rest.connector;


import com.etf.rest.model.ComplexModel;
import com.etf.rest.model.SimpleModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rest", url = "http://localhost:8080")
public interface IRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    void test();

    @RequestMapping(method = RequestMethod.GET, value = "/objects/string")
    String getString();

    @RequestMapping(method = RequestMethod.GET, value = "/objects/simpleobject")
    SimpleModel getSimpleObject();

    @RequestMapping(method = RequestMethod.GET, value = "/objects/complexobject")
    ComplexModel getComplexObject();
}