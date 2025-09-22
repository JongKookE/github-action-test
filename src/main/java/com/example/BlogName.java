package com.example;

public enum BlogName {
    WOOAHAN("우아한 형제들"),
    PROGRAMMERS("프로그래머스");

    private final String name;

    BlogName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}