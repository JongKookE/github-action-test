package com.example;

public enum TechBlogUrl {
    WOOAHAN("https://techblog.woowahan.com"),
    PROGRAMMERS("https://prgms.tistory.com/");

    private final String url;
    private TechBlogUrl(String url) {
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}