package com.example.domain;

public class WorkerFix extends Worker {
    public WorkerFix(String name) {
        super(name);
    }

    @Override
    public double salary() { // Fix
        return 20.8 * 8 * 5;
    }
}
