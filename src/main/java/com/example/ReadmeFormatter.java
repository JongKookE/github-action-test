package com.example;

import java.time.LocalDateTime;

public class ReadmeFormatter {
    void actionStart(StringBuilder sb){
        sb.append("# tech-blog-commit-bot\n").append("기술 블로그의 글을 매일 매일 갱신해주는 봇 \uD83E\uDD16\n");
        LocalDateTime date = LocalDateTime.now().plusHours(9);

        sb.append("## ⏲ ")
                .append(date.getYear()).append("년 ")
                .append(date.getMonthValue()).append("월 ")
                .append(date.getDayOfMonth()).append("일 ")
                .append(date.getHour()).append("시 ")
                .append(date.getMinute()).append("분의 업데이트 내용입니다.\n");
    }

    void titleToLink(StringBuilder sb, String title, String link) {
        sb.append("- [")
            .append(title)
            .append("](")
            .append(link)
            .append(")")
            .append("\n\n");
    }

    void setH2(StringBuilder sb, String title){
        sb.append("## ")
            .append("\uD83C\uDF83")
            .append(title)
            .append("\n\n")
            .append("---\n");
    }
}