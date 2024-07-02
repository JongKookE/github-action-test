package com.example.tech_blog.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UpdateService {
    public void updateReadme() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("# tech-blog-commit-bot\n").append("유명 기업의 기술 블로그의 글을 매일 매일 갱신해주는 봇 \uD83E\uDD16\n");
        LocalDateTime date = LocalDateTime.now().plusHours(9);

        sb.append("## ⏲ ").append(date.getYear()).append("년 ").append(date.getMonthValue()).append("월 ").append(date.getDayOfMonth()); //.append("일의 업데이트 내용입니다.").append("\n");
        sb.append("일 ").append(date.getHour()).append("시 ").append(date.getMinute()).append("분의 업데이트 내용입니다.\n");
        String[] docs = {"https://prgms.tistory.com/"};
        Document doc = Jsoup.connect(docs[0]).get();
        List<Element> last = doc.select("#main > div > div.index_type_common.index_type_post.index_type_post_line4 > div.article_content > a.link_title");
        List<Element> elements = doc.select("#main > div > div.index_type_common.index_type_gallery > ul > li > div > a.link_title");

        for (Element element: last){
            String title = element.text();
            String link = "https://prgms.tistory.com" + element.attr("href");
            sb.append(titleToLink(title, link));
        }

        for (Element element: elements) {
            String title = element.text();
            String link = "https://prgms.tistory.com" + element.attr("href");
            sb.append(titleToLink(title, link));
        }

        File readme = new File("README.md");
        // 파일이 없다면 새로 만들고, 파일이 있다면 덮어씌운다.
        FileWriter writer = new FileWriter(readme, false);
        writer.write(sb.toString());
        writer.close();
    }

    private String titleToLink(String title, String link) {
        return "[" + title + "](" + link + ")" + "\n\n";
    }


}
