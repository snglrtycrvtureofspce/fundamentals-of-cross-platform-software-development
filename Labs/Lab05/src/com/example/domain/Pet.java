package com.example.domain;

import java.util.Scanner;

public abstract class Pet {
    private String _name;

    public Pet()
    {
        try
        {
            if(_name == null)
            {
                throw new Exception();
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя животного:");
            String name = scanner.nextLine();
        }
        catch (Exception exception)
        {
            System.out.println("Пустая строка");
        }

    }
    public Pet(String name)
    {
        _name = name;
    }

    @Override
    public String toString()
    {
        try
        {
            return "Имя животного: " + _name;
        }
        catch (IllegalMonitorStateException exception)
        {
            System.out.println("Hеверная операция мониторинга");
        }
        catch (Exception exceptio)
        {
            System.out.println("Какая-то ошибка");
        }
        finally
        {
            return "Имя животного: " + _name;
        }
    }
}
