package com.example.domain;

public class WorkerHour extends Worker {
    public WorkerHour(String name) {
        super(name);
    }

    @Override
    public double salary() { // hour
        return 20.8 * 8 * 3.3;
    }
}
