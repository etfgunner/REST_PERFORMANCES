package com.etf.rest.controller;

import com.etf.rest.model.ComplexModel;
import com.etf.rest.model.SimpleModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResourcesController {
    private final String STRING_VALUE = "EXAMPLE";
    private final String STRING_DESCRIPTION = "THIS IS EXAMPLE DESCRIPTION FOR TESTING PERFORMANCE OF PROTOCOLS";

    @GetMapping(path = "/test")
    public void test() {
        return ;
    }

    @GetMapping(path = "/objects/string")
    public String getString() {
        return STRING_VALUE;
    }

    @GetMapping(path = "/objects/simpleobject")
    public SimpleModel getSimpleObject() {
        return getSimpleModel();
    }

    @GetMapping(path = "/objects/complexobject")
    public ComplexModel getComplexObject() {
        return getComplexModel();
    }

    private SimpleModel getSimpleModel() {
        return new SimpleModel(Long.MAX_VALUE, STRING_VALUE, STRING_DESCRIPTION, true, Long.MIN_VALUE);
    }

    private ComplexModel getComplexModel() {
        List<Double> doubleList = new ArrayList<Double>();
        List<String> stringList = new ArrayList<String>();
        for(int i = 0 ; i < 50; i++) {
            doubleList.add(new Double(1.01));
            stringList.add(STRING_VALUE);
        }
        return new ComplexModel(doubleList, stringList);
    }
}
