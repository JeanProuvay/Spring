package com.example.theards;

import java.util.concurrent.Callable;

public class CHilo implements Callable {
    @Override
    public String call() throws Exception {
        return "Hilo Callable";
    }
}
