package com.etf.rest.model;

import java.util.List;

public class ComplexModel {
    private List<Double> numbers;
    private List<String> strings;

    public ComplexModel() {
    }

    public ComplexModel(List<Double> numbers, List<String> strings) {
        this.numbers = numbers;
        this.strings = strings;
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Double> numbers) {
        this.numbers = numbers;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
