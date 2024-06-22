package com.example.tech_blog;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
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

        String myRepoURL = "https://github.com/JongKookE/github-action-test";
        Repository repository = new FileRepositoryBuilder()
                .setGitDir(new File(myRepoURL + "/git"))
                .build();

        Git git = new Git(repository);

        sb.append("## 푸쉬 테스트");

        File readmeFile = new File(myRepoURL + "/README.md");
        FileWriter writer = new FileWriter(readmeFile, true); // append 모드로 열기
        writer.write(sb.toString());
        writer.close();

        git.commit()
                // 변경사항 모두 commit
                .setAll(true)
                // commit message
                .setMessage("리드미 업데이트!")
                .call();


    }

}
