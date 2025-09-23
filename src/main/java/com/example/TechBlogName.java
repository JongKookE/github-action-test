package com.example;

public enum TechBlogName {
    WOOAHAN("우아한 형제들"),
    PROGRAMMERS("프로그래머스");

    private final String name;

    TechBlogName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}