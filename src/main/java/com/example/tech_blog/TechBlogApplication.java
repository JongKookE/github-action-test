package com.example.tech_blog;

import com.example.tech_blog.service.UpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TechBlogApplication implements CommandLineRunner {
    final UpdateService updateService;
    public static void main(String[] args) {

        SpringApplication.run(TechBlogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        updateService.updateReadme();
//        updateService.woowahan();
    }
}
