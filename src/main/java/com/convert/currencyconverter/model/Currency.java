package com.convert.currencyconverter.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

//import javax.persistence.Id;
@RedisHash("Currency")
public class Currency {

    @Id
    private String name;
    private double valueInEuros;

    public Currency() {
    }

    public Currency(String name, double valueInEuros) {
        this.name = name;
        this.valueInEuros = valueInEuros;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValueInEuros() {
        return valueInEuros;
    }

    public void setValueInEuros(double valueInEuros) {
        this.valueInEuros = valueInEuros;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", valueInUsd=" + valueInEuros +
                '}';
    }
}
