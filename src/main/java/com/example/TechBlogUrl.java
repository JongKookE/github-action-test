package com.example;

public enum TechBlogUrl {
    WOOAHAN("https://techblog.woowahan.com"),
    PROGRAMMERS("https://prgms.tistory.com/"),
    TOSS("https://toss.tech/");

    private final String url;
    TechBlogUrl(String url) {
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}