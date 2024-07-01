package com.example.tech_blog;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class TechBlogApplication {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException, GitAPIException {

        SpringApplication.run(TechBlogApplication.class, args);

        String[] docs = {"https://prgms.tistory.com/"};
        Document doc = Jsoup.connect(docs[0]).get();
        List<Element> last = doc.select("#main > div > div.index_type_common.index_type_post.index_type_post_line4 > div.article_content > a.link_title");
        List<Element> elements = doc.select("#main > div > div.index_type_common.index_type_gallery > ul > li > div > a.link_title");

        for (Element element: last){
            String link = "https://prgms.tistory.com" + element.attr("href");
            String title = element.text();
            sb.append(title).append(" ").append(link);
        }

        for (Element element: elements) {
            String link = "https://prgms.tistory.com" + element.attr("href");
            String title = element.text();
            sb.append(title).append(" ").append(link);
        }
        System.out.println(sb);
    }

}
