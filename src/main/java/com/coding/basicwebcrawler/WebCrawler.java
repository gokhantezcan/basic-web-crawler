package com.coding.basicwebcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WebCrawler {
    private Set<String> visitedUrlLinks = new HashSet<>();

    public void extractLinksFromPage(String URL) {

        if (!visitedUrlLinks.contains(URL)) {
            try {
                if (visitedUrlLinks.add(URL)) {
                    System.out.println(URL);
                }
                Document document = getDocumentAsHtml(URL);
                getUrlsFromPage(document);
            } catch (IOException e) {
                System.err.println("Error for this URL: " + URL);
            }
        }
    }

    private Document getDocumentAsHtml(String Url) throws IOException {
        Document documents = Jsoup.connect(Url).get();
        return documents;
    }

    private void getUrlsFromPage(Document documents) {
        Elements linksOnPage = documents.select("a[href]");
        for (Element ele : linksOnPage) {
            extractLinksFromPage(ele.attr("abs:href"));
        }
    }
}