package com.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    static ReadmeFormatter readmeFormatter = new ReadmeFormatter();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        readmeFormatter.actionStart(sb);
        programmers();
        wooahan();
        File readme = new File("README.md");
        // 파일이 없다면 새로 만들고, 파일이 있다면 덮어씌운다.
        FileWriter writer = new FileWriter(readme, false);
        writer.write(sb.toString());
        writer.close();

        sb.setLength(0);
    }
    public static void programmers() throws IOException {
        readmeFormatter.setH2(sb, TechBlogName.PROGRAMMERS.getName());
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

    public static void wooahan() throws IOException {
        readmeFormatter.setH2(sb, TechBlogName.WOOAHAN.getName());
        Document doc = Jsoup.connect(TechBlogUrl.WOOAHAN.getUrl()).get();
        List<Element> titles = doc.select("div.post-list div.post-item a");
        int indexSize = 10;
        // indexSize를 조정안하고 for-each를 사용하면 알수없는 태그들도 같이 넘어와서 포스트의 사이즈로 순회
        for(int index = 0; index < indexSize; index++){
            Element element = titles.get(index);
            String title = element.select("h2.post-title").text();
            String link = element.select("a").attr("href");
            readmeFormatter.titleToLink(sb, title, link);
        }
    }
}