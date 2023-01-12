package com.example.domain;

public class Product {
    private String _name;
    private int _price;
    private int _quality;

    public Product(){}

    public Product(String name, int price, int quality){
        try
        {
            _name = name;
            _price = price;
            _quality = quality;
        }
        catch (Exception e)
        {
            System.out.println("Какая-то ошибка!");
        }
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public int getPrice() {return _price;}

    public void setPrice(int _price)  {
        if (this._price > 0)
        {
            this._price = _price;
        }
        else
        {
            try {
                throw new Exception("xd");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getQuality() {return _quality;}

    public void setQuality(int _quality)
    {
        try
        {
            this._quality = _quality;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return " Имя:" + getName() + " Цена:" + getPrice() + " Качество:" + getQuality();
    }


}
