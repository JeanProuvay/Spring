package com.example.theards;

public class THilo extends Thread{

    private int id;

    public THilo(int id) {
        this.id = id;
    }

    @Override
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("Ejecutandose hilo de id -->" + id);
        }
    }
}
