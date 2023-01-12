package com.example.domain;

public class SotrPoContract extends Worker{
    public double years;
    public SotrPoContract(String name,String Dolj,double Oklad,double years)
    {
        super(name, Dolj, Oklad);
        this.years=years;
    }
    public void getYear(double years)
    {
        this.years = years;
    }
    public double setYear()
    {
        return this.years;
    }

    @Override
    public double salary(double hour)
    {
        try
        {
            if(hour==0)
            {
                throw new Exception();
            }
        }
        catch (ArithmeticException x)
        {
            System.out.println("Кол-во часов не может быть больше!");
        }
        catch (Exception e)
        {
            System.out.println("Ошибка!");
        }
        finally
        {
            return zp / hour*(years*365);
        }
    }
}
