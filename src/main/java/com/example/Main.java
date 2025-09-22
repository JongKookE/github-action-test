package com.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class Main {
    static ReadmeFormatter readmeFormatter = new ReadmeFormatter();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        readmeFormatter.actionStart(sb);
        programmers();
        System.out.println(sb.toString());

    }
    public static void programmers() throws IOException {
        Document doc = Jsoup.connect(TechBlogUrl.PROGRAMMERS.getUrl()).get();
        List<Element> last = doc.select("#main > div > div.index_type_common.index_type_post.index_type_post_line4 > div.article_content > a.link_title");
        List<Element> elements = doc.select("#main > div > div.index_type_common.index_type_gallery > ul > li > div > a.link_title");

        for (Element element: last){
            String title = element.text();
            String link = TechBlogUrl.PROGRAMMERS.getUrl() + element.attr("href");
            readmeFormatter.titleToLink(sb, title, link);
        }

        for (Element element: elements) {
            String title = element.text();
            String link = TechBlogUrl.PROGRAMMERS.getUrl() + element.attr("href");
            readmeFormatter.titleToLink(sb, title, link);
        }
    }
}