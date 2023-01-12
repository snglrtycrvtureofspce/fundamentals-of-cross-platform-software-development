package com.example.domain;

public class PremyaException extends Exception{
    private double premia;
    public double getPremia(){return premia;}
    public PremyaException(){}
    public PremyaException(String message,double premia)
    {
        super(message);
        this.premia = premia;
    }
}
