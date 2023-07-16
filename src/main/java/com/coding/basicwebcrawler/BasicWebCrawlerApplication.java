package com.coding.basicwebcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BasicWebCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicWebCrawlerApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plese enter a URL");
        String url = scanner.nextLine();
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.extractLinksFromPage(url);
    }

}
